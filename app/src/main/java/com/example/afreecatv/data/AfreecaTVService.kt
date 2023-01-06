package com.example.afreecatv.data

import com.example.afreecatv.data.board.BroadResponse
import com.example.afreecatv.data.category.BoardCategoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AfreecaTVService {
    @GET(Url.BOARD_LIST_URL)
    suspend fun getBoardList(
        @Query("client_id") clientId: String = Url.CLIENT_ID,
        @Query("select_key") selectKey: String = "cate",
        @Query("select_value") selectValue: String,
        @Query("page_no") pageNo: Int = 1
    ): BroadResponse

    @GET(Url.CATEGORY_LIST_URL)
    suspend fun getCategoryList(
        @Query("client_id") clientId: String = Url.CLIENT_ID
    ): BoardCategoryResponse
}