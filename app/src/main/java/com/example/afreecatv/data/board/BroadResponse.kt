package com.example.afreecatv.data.board

import com.example.afreecatv.presentation.main.model.BroadModel
import com.google.gson.annotations.SerializedName

data class BroadResponse(
    @SerializedName("total_cnt") val totalCnt: Int,
    @SerializedName("page_no") val pageNo: Int,
    @SerializedName("page_block") val pageBlock: Int,
    @SerializedName("broad") val broad: List<Broad>,
    @SerializedName("time") val time: Int
)

data class Broad(
    @SerializedName("broad_title") val broadTitle: String,
    @SerializedName("visit_broad_type") val visitBroadType: String,
    @SerializedName("is_password") val isPassword: String,
    @SerializedName("broad_cate_no") val broadCateNo: String,
    @SerializedName("broad_no") val broadNo: String,
    @SerializedName("user_id") val userId: String,
    @SerializedName("user_nick") val userNick: String,
    @SerializedName("profile_img") val profileImg: String,
    @SerializedName("broad_thumb") val broadThumb: String,
    @SerializedName("broad_start") val broadStart: String,
    @SerializedName("broad_grade") val broadGrade: String,
    @SerializedName("broad_resolution") val broadResolution: String,
    @SerializedName("total_view_cnt") val totalViewCnt: String
) {
    fun toBroadModel() =
        BroadModel(
            broadTitle,
            visitBroadType,
            isPassword,
            broadCateNo,
            broadNo,
            userId,
            userNick,
            "https:$profileImg",
            "https:$broadThumb",
            broadStart,
            broadGrade,
            broadResolution,
            totalViewCnt
        )
}
