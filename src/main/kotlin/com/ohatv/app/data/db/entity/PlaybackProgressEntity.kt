package com.ohatv.app.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playback_progress")
data class PlaybackProgressEntity(
    @PrimaryKey
    val contentId: String,
    val contentTitle: String,
    val currentPosition: Long,
    val duration: Long,
    val lastWatched: Long = System.currentTimeMillis()
)
