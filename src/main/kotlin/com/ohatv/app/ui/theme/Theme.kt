package com.ohatv.app.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.darkColorScheme
import androidx.tv.material3.lightColorScheme

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF00BCD4),
    secondary = Color(0xFF03DAC6),
    tertiary = Color(0xFF03DAC6),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    error = Color(0xFFCF6679),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00BCD4),
    secondary = Color(0xFF03DAC6),
    tertiary = Color(0xFF03DAC6),
    background = Color(0xFFFAFAFA),
    surface = Color(0xFFFFFFFF),
    error = Color(0xFFB00020),
)

@Composable
fun OhaTVTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = OhaTVTypography,
        content = content
    )
}
