package com.example.afreecatv.data.board

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BoardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(blogs: List<BroadEntity>)

    @Query("SELECT * FROM broad WHERE broadCateNo == :cateNo")
    fun getBroadList(cateNo: String): PagingSource<Int, BroadEntity>
}