package com.example.afreecatv.data.board

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.afreecatv.data.AfreecaTVService
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class BroadRemoteMediator(
    val category: String,
    private val db: BroadDB,
    private val api: AfreecaTVService
): RemoteMediator<Int, BroadEntity>() {

    private val broadDao = db.getBroadDao()
    private val broadKeyDao = db.getBroadKeyDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BroadEntity>
    ): MediatorResult {
        try {
            val loadLastIndex = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val index = db.withTransaction {
                        broadKeyDao.getRemoteKey()
                    }.key
                    index
                }
            }

            val broadList = api.getBoardList(
                selectValue = category,
                pageNo = loadLastIndex
            ).broad

            Log.d("MediatorResult", "size: ${broadList.size} load: ${broadList.map { it.broadThumb } }}")

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                }
                broadDao.insertAll(broadList.map { it.toBroadEntity() })
                broadKeyDao.insert(BroadKeyEntity((loadLastIndex + state.config.pageSize)))
            }

            return MediatorResult.Success(endOfPaginationReached = broadList.isEmpty())

        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }
}