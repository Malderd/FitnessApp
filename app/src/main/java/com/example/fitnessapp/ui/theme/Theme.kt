package com.example.fitnessapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = GreenPrimary,
    onPrimary = White,

    secondary = GreenSecondary,
    onSecondary = White,

    tertiary = GreenTertiary,
    onTertiary = GreenPrimary,

    background = Color(0xFFEAF1EA),
    onBackground = Color(0xFF243328),

    surface = White,
    onSurface = Color(0xFF243328),

    surfaceVariant = Color(0xFFF7F9F7),
    onSurfaceVariant = Color(0xFF718071),

    outline = Color(0xFFD0D8D0)
)

private val DarkColorScheme = darkColorScheme(
    primary = DarkGreenPrimary,
    onPrimary = Color(0xFF102513),

    secondary = DarkGreenSecondary,
    onSecondary = Color(0xFF263329),

    tertiary = DarkGreenTertiary,
    onTertiary = Color(0xFFE7F0E8),

    background = Color(0xFF121A16),
    onBackground = Color(0xFFE5EDE6),

    surface = Color(0xFF1D2922),
    onSurface = Color(0xFFE5EDE6),

    surfaceVariant = Color(0xFF2B3A30),
    onSurfaceVariant = Color(0xFFB3C1B5),

    outline = Color(0xFF536457)
)

@Composable
fun FitnessAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}