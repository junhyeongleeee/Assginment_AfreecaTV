package com.example.afreecatv.data.category

import com.example.afreecatv.data.AfreecaTVService
import kotlinx.coroutines.Dispatchers

interface CategoryRepository {
    suspend fun getCategoryList(): List<Category>
}

class CategoryRepositoryImpl(
    private val api: AfreecaTVService
) : CategoryRepository {
    override suspend fun getCategoryList(): List<Category> = with(Dispatchers.IO) {
        val list = api.getCategoryList().categoryList
        return list
    }
}