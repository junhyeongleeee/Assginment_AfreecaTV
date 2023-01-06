package com.example.afreecatv.data.board

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.afreecatv.presentation.main.model.BroadModel

@Entity(tableName = "broad")
data class BroadEntity(
    val broadTitle: String,
    val visitBroadType: String,
    val isPassword: String,
    val broadCateNo: String,
    @PrimaryKey
    val broadNo: String,
    val userId: String,
    val userNick: String,
    val profileImg: String,
    val broadThumb: String,
    val broadStart: String,
    val broadGrade: String,
    val broadResolution: String,
    val totalViewCnt: String
) {
    fun toBroadModel() = BroadModel(
        broadTitle,
        visitBroadType,
        isPassword,
        broadCateNo,
        broadNo,
        userId,
        userNick,
        profileImg,
        broadThumb,
        broadStart,
        broadGrade,
        broadResolution,
        totalViewCnt
    )
}