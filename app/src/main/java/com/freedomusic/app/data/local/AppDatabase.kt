package com.freedomusic.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.freedomusic.app.data.local.dao.PlaylistDao
import com.freedomusic.app.data.local.dao.TrackDao
import com.freedomusic.app.data.local.entity.PlaylistEntity
import com.freedomusic.app.data.local.entity.PlaylistTrackCrossRef
import com.freedomusic.app.data.local.entity.TrackEntity

@Database(
    entities = [
        TrackEntity::class,
        PlaylistEntity::class,
        PlaylistTrackCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trackDao(): TrackDao
    abstract fun playlistDao(): PlaylistDao
}
