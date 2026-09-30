package com.freedomusic.app.player.engine

import androidx.media3.common.MediaItem

enum class CrossfadeMode {
    NONE, SIMPLE, DJ_COMPLEX
}

interface PlaybackEngine {
    fun play(mediaItem: MediaItem)
    fun pause()
    fun stop()
    fun seekTo(positionMs: Long)
    fun setCrossfadeMode(mode: CrossfadeMode)
    fun setVolume(volume: Float)
    fun release()

    // Additional methods for queuing could be added depending on how ExoPlayer integrates
}
