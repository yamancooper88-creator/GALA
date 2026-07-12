package com.ohatv.app.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channels")
data class ChannelEntity(
    @PrimaryKey
    val channelId: String,
    val channelName: String,
    val channelUrl: String,
    val logoUrl: String? = null,
    val group: String? = null,
    val isFavorite: Boolean = false
)
