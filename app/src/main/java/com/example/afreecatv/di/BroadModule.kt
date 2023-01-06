package com.example.afreecatv.di

import com.example.afreecatv.data.AfreecaTVService
import com.example.afreecatv.data.board.BroadRepository
import com.example.afreecatv.data.board.BroadRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BroadModule {

    @Provides
    @Singleton
    fun provideBroadRepository(
        api: AfreecaTVService
    ): BroadRepository = BroadRepositoryImpl(api)
}