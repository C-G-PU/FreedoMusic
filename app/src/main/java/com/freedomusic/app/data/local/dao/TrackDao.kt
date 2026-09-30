package com.freedomusic.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.freedomusic.app.data.local.entity.TrackEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackDao {
    @Query("SELECT * FROM tracks")
    fun getAllTracks(): Flow<List<TrackEntity>>

    @Query("SELECT * FROM tracks WHERE id = :trackId LIMIT 1")
    suspend fun getTrackById(trackId: Long): TrackEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tracks: List<TrackEntity>)

    @Update
    suspend fun updateTrack(track: TrackEntity)

    @Query("UPDATE tracks SET customCoverUri = :coverUri WHERE id = :trackId")
    suspend fun updateCustomCover(trackId: Long, coverUri: String?)

    @Query("UPDATE tracks SET customLyrics = :lyrics WHERE id = :trackId")
    suspend fun updateCustomLyrics(trackId: Long, lyrics: String?)

    @Query("SELECT * FROM tracks WHERE title LIKE '%' || :query || '%' OR artist LIKE '%' || :query || '%'")
    fun searchTracks(query: String): Flow<List<TrackEntity>>
}
