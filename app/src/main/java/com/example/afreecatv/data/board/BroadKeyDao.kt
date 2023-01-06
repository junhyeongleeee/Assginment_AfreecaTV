package com.example.afreecatv.data.board

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BroadKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(key: BroadKeyEntity)

    @Query("SELECT * FROM broad_key ORDER BY ROWID DESC LIMIT 1")
    suspend fun getRemoteKey(): BroadKeyEntity
}