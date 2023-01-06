package com.example.afreecatv.data.board

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "broad_key")
data class BroadKeyEntity(
    @PrimaryKey
    val key: Int
)
