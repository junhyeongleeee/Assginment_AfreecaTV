package com.example.afreecatv.data.board

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.afreecatv.data.AfreecaTVService
import com.example.afreecatv.data.category.Category
import com.example.afreecatv.presentation.main.model.BroadModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface BroadRepository {
    fun getBroadList(category: Category): Flow<PagingData<BroadModel>>
}

class BroadRepositoryImpl(
    private val api: AfreecaTVService
) : BroadRepository {

    override fun getBroadList(category: Category): Flow<PagingData<BroadModel>> {
        return Pager(config = PagingConfig(pageSize = BroadPagingSource.PAGING_SIZE)) {
            BroadPagingSource(category.cateNo, api)
        }.flow.map { pagingData ->
            pagingData.map { entity ->
                entity.toBroadModel()
            }
        }
    }
}