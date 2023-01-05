package com.example.afreecatv.di

import com.example.afreecatv.data.AfreecaTVService
import com.example.afreecatv.data.category.CategoryRepository
import com.example.afreecatv.data.category.CategoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoryModule {
    @Provides
    @Singleton
    fun provideCategoryRepository(
        api: AfreecaTVService
    ): CategoryRepository = CategoryRepositoryImpl(api)
}