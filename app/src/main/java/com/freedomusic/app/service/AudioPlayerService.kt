package com.freedomusic.app.service

import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService
import com.freedomusic.app.player.engine.CrossfadeMode

class AudioPlayerService : MediaSessionService() {

    private var mediaSession: MediaSession? = null
    private lateinit var player: ExoPlayer // Base player for generic Media3 connection

    // In a full implementation, we'd wrap our Custom PlaybackEngine into a Media3 Player interface
    // or run them side-by-side depending on CrossfadeMode.
    private var currentMode = CrossfadeMode.NONE

    override fun onCreate() {
        super.onCreate()

        // Initialize basic player for MediaSession
        player = ExoPlayer.Builder(this).build()
        mediaSession = MediaSession.Builder(this, player).build()
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession? {
        return mediaSession
    }

    override fun onDestroy() {
        mediaSession?.run {
            player.release()
            release()
            mediaSession = null
        }
        super.onDestroy()
    }
}
