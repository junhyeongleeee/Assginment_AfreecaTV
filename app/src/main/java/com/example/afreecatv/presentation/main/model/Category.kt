package com.example.afreecatv.presentation.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class Category(val category: String) : Parcelable {
    TOOK_CAM("토크/캠방"), TRAVEL("여행"), EAT_COOK("먹방/쿡방")
}