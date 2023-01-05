package com.example.afreecatv.data.category

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class BoardCategoryResponse(
    @SerializedName("broad_category") val categoryList: List<Category>
)

@Parcelize
data class Category(
    @SerializedName("cate_name") val cateName: String,
    @SerializedName("cate_no") val cateNo: String,
    @SerializedName("child") val childList: List<ChildCategory>
) : Parcelable

@Parcelize
data class ChildCategory(
    @SerializedName("cate_name") val cateName: String,
    @SerializedName("cate_no") val cateNo: String
) : Parcelable
