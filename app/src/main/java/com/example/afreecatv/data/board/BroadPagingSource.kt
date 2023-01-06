package com.example.afreecatv.data.board

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.afreecatv.data.AfreecaTVService
import java.io.IOException

class BroadPagingSource(
    val category: String,
    private val api: AfreecaTVService
) : PagingSource<Int, Broad>() {

    override fun getRefreshKey(state: PagingState<Int, Broad>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Broad> {
        return try {
            val pageNumber = params.key ?: STARTING_PAGE_INDEX

            val broadList = api.getBoardList(
                selectValue = category,
                pageNo = pageNumber
            ).broad

            val prevKey = if (pageNumber == STARTING_PAGE_INDEX) null else pageNumber - 1
            val nextKey = if (broadList.isEmpty()) null else {
                pageNumber + 1
            }

            LoadResult.Page(broadList, prevKey, nextKey)
        } catch (e: IOException) {
            LoadResult.Error(e)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val STARTING_PAGE_INDEX = 1
        const val PAGING_SIZE = 60
    }
}