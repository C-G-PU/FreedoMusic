package com.freedomusic.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tracks")
data class TrackEntity(
    @PrimaryKey val id: Long, // MediaStore ID or custom ID
    val title: String,
    val artist: String,
    val album: String,
    val duration: Long,
    val data: String, // Path to file on device
    val defaultCoverUri: String? = null,
    val customCoverUri: String? = null, // Path to user-selected cover art
    val defaultLyrics: String? = null,
    val customLyrics: String? = null // User-provided lyrics
)
