package com.freedomusic.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = ThemeBlackPrimary,
    surface = ThemeBlackSecondary
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = ThemeWhitePrimary,
    surface = ThemeWhiteSecondary

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

enum class AppThemeType {
    SYSTEM, BLACK, GREY, WHITE, PINK, CUSTOM
}

@Composable
fun FreedoMusicTheme(
    appThemeType: AppThemeType = AppThemeType.SYSTEM,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when (appThemeType) {
        AppThemeType.BLACK -> DarkColorScheme.copy(background = ThemeBlackPrimary, surface = ThemeBlackSecondary)
        AppThemeType.GREY -> DarkColorScheme.copy(background = ThemeGreyPrimary, surface = ThemeGreySecondary)
        AppThemeType.WHITE -> LightColorScheme.copy(background = ThemeWhitePrimary, surface = ThemeWhiteSecondary)
        AppThemeType.PINK -> LightColorScheme.copy(background = ThemePinkPrimary, surface = ThemePinkSecondary)
        AppThemeType.SYSTEM -> {
            val context = LocalContext.current
            if (dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            } else {
                if (darkTheme) DarkColorScheme else LightColorScheme
            }
        }
        else -> if (darkTheme) DarkColorScheme else LightColorScheme // Custom logic to be implemented later
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        // typography = Typography, // You can add custom typography here
        content = content
    )
}
