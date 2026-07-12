package com.ohatv.app.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ohatv.app.data.db.entity.PlaybackProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaybackProgressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(progress: PlaybackProgressEntity)

    @Query("SELECT * FROM playback_progress WHERE contentId = :contentId")
    suspend fun getProgress(contentId: String): PlaybackProgressEntity?

    @Query("SELECT * FROM playback_progress ORDER BY lastWatched DESC LIMIT 10")
    fun getRecentlyWatched(): Flow<List<PlaybackProgressEntity>>

    @Query("DELETE FROM playback_progress WHERE contentId = :contentId")
    suspend fun deleteProgress(contentId: String)
}
