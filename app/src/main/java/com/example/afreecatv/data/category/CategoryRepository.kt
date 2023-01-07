package com.example.afreecatv.data.category

import com.example.afreecatv.data.AfreecaTVService

interface CategoryRepository {
    suspend fun getCategoryList(): List<Category>
}

class CategoryRepositoryImpl(
    private val api: AfreecaTVService
) : CategoryRepository {
    override suspend fun getCategoryList(): List<Category> =
        api.getCategoryList().categoryList
}