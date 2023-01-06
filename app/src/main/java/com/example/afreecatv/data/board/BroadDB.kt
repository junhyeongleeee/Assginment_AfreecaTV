package com.example.afreecatv.data.board

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [BroadEntity::class, BroadKeyEntity::class],
    version = 1,
    exportSchema = false
)
abstract class BroadDB : RoomDatabase() {
    companion object {
        fun create(context: Context): BroadDB {
            val databaseBuilder =
                Room.databaseBuilder(context, BroadDB::class.java, "broad.db")
            return databaseBuilder.fallbackToDestructiveMigration().build()
        }
    }
    abstract fun getBroadDao(): BoardDao
    abstract fun getBroadKeyDao(): BroadKeyDao
}
