package com.freedomusic.app.player.engine

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer

class SimpleCrossfadeEngine(private val context: Context) : PlaybackEngine {

    private val player1 = ExoPlayer.Builder(context).build()
    private val player2 = ExoPlayer.Builder(context).build()

    private var activePlayer: ExoPlayer = player1
    private var nextPlayer: ExoPlayer = player2

    private var currentMode = CrossfadeMode.SIMPLE
    private var globalVolume = 1f

    override fun play(mediaItem: MediaItem) {
        if (currentMode == CrossfadeMode.NONE) {
            activePlayer.setMediaItem(mediaItem)
            activePlayer.prepare()
            activePlayer.play()
            return
        }

        // Logic for crossfading. Real implementation requires tracking time
        // and starting nextPlayer before activePlayer finishes.
        // For simplicity in this structure:
        nextPlayer.setMediaItem(mediaItem)
        nextPlayer.prepare()

        // Pseudo-crossfade start (Simulating volume fade would require Coroutines/Handler)
        activePlayer.volume = 0f
        nextPlayer.volume = globalVolume
        nextPlayer.play()

        // Swap
        val temp = activePlayer
        activePlayer = nextPlayer
        nextPlayer = temp
    }

    override fun pause() {
        activePlayer.pause()
    }

    override fun stop() {
        activePlayer.stop()
        nextPlayer.stop()
    }

    override fun seekTo(positionMs: Long) {
        activePlayer.seekTo(positionMs)
    }

    override fun setCrossfadeMode(mode: CrossfadeMode) {
        this.currentMode = mode
    }

    override fun setVolume(volume: Float) {
        this.globalVolume = volume
        activePlayer.volume = volume
    }

    override fun release() {
        player1.release()
        player2.release()
    }
}
