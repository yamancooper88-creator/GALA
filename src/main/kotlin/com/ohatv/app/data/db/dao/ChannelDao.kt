package com.ohatv.app.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ohatv.app.data.db.entity.ChannelEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChannelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChannels(channels: List<ChannelEntity>)

    @Query("SELECT * FROM channels ORDER BY channelName")
    fun getAllChannels(): Flow<List<ChannelEntity>>

    @Query("SELECT * FROM channels WHERE isFavorite = 1 ORDER BY channelName")
    fun getFavoriteChannels(): Flow<List<ChannelEntity>>

    @Query("SELECT * FROM channels WHERE `group` = :group ORDER BY channelName")
    fun getChannelsByGroup(group: String): Flow<List<ChannelEntity>>

    @Query("UPDATE channels SET isFavorite = :isFavorite WHERE channelId = :channelId")
    suspend fun updateFavorite(channelId: String, isFavorite: Boolean)

    @Query("DELETE FROM channels")
    suspend fun deleteAllChannels()
}
