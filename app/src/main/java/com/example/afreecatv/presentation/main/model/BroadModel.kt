package com.example.afreecatv.presentation.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BroadModel(
    val broadTitle: String,
    val visitBroadType: String,
    val isPassword: String,
    val broadCateNo: String,
    val broadNo: String,
    val userId: String,
    val userNick: String,
    val profileImg: String,
    val broadThumb: String,
    val broadStart: String,
    val broadGrade: String,
    val broadResolution: String,
    val totalViewCnt: String
): Parcelable