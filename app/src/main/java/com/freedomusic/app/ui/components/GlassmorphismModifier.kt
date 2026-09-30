package com.freedomusic.app.ui.components

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer

/**
 * Applies a Glassmorphism effect.
 * Note: Blur effect is only natively supported on Android 12 (API 31+).
 */
fun Modifier.glassmorphism(
    shape: Shape,
    blurRadius: Float = 50f,
    overlayColor: Color = Color.White.copy(alpha = 0.2f)
): Modifier = this
    .clip(shape)
    .background(overlayColor)
    .graphicsLayer {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            renderEffect = RenderEffect
                .createBlurEffect(
                    blurRadius,
                    blurRadius,
                    Shader.TileMode.DECAL
                )
                .asComposeRenderEffect()
        }
    }
