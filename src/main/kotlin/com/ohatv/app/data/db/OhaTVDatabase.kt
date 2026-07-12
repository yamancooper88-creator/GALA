package com.ohatv.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ohatv.app.data.db.dao.PlaybackProgressDao
import com.ohatv.app.data.db.dao.ChannelDao
import com.ohatv.app.data.db.entity.PlaybackProgressEntity
import com.ohatv.app.data.db.entity.ChannelEntity

@Database(
    entities = [
        PlaybackProgressEntity::class,
        ChannelEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class OhaTVDatabase : RoomDatabase() {
    abstract fun playbackProgressDao(): PlaybackProgressDao
    abstract fun channelDao(): ChannelDao
}
