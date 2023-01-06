package com.example.afreecatv.di

import android.content.Context
import com.example.afreecatv.data.board.BroadDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BroadDBModule {

    @Provides
    @Singleton
    fun provideDB(
        @ApplicationContext context: Context
    ): BroadDB = BroadDB.create(context)
}
