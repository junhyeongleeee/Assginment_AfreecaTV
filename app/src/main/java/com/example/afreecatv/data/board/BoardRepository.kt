package com.example.afreecatv.data.board

import android.util.Log
import androidx.paging.*
import com.example.afreecatv.data.AfreecaTVService
import com.example.afreecatv.data.category.Category
import com.example.afreecatv.presentation.main.adapter.BroadModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface BoardRepository {
    fun getBoardList(category: Category): Flow<PagingData<BroadModel>>
}

class BoardRepositoryImpl(
    private val db: BroadDB,
    private val api: AfreecaTVService
) : BoardRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getBoardList(category: Category): Flow<PagingData<BroadModel>> {
        Log.d("BoardRepository", "getBoardList: ${category.cateNo}")
        return Pager(
            config = PagingConfig(pageSize),
            remoteMediator = BroadRemoteMediator(
                category.cateNo,
                db,
                api
            ),
        ) {
            db.getBroadDao().getBroadList(category.cateNo)
        }.flow.map { pagingData ->
            pagingData.map { entity ->
                entity.toBroadModel()
            }
        }
    }

    companion object {
        const val pageSize = 60
    }
}