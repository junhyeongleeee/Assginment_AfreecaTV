package com.example.afreecatv.di

import com.example.afreecatv.data.AfreecaTVService
import com.example.afreecatv.data.board.BoardRepository
import com.example.afreecatv.data.board.BoardRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BoardModule {

    @Provides
    @Singleton
    fun provideBoardRepository(
        api: AfreecaTVService
    ): BoardRepository = BoardRepositoryImpl(api)
}