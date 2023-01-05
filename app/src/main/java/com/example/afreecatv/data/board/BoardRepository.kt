package com.example.afreecatv.data.board

import com.example.afreecatv.data.AfreecaTVService
import com.example.afreecatv.data.broad.BroadModel

interface BoardRepository {
    suspend fun getBoardList(): List<BroadModel>
}

class BoardRepositoryImpl(
    private val api: AfreecaTVService
): BoardRepository {
    override suspend fun getBoardList(): List<BroadModel> {
        return api.getBoardList().broadModel
    }
}