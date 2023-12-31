package com.dev.chacha.ui.common.theme

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color



val primaryDarkVariant = Color(0xFF393939)
val primaryPink = Color(0xFFFE0A58)
val primaryGray = Color(0xFF828588)
val lightGray = Color(0xFFF7F7F7)
val Transparent = Color(0x00FFFFFF)
val TextWhite = Color(0xFFEEEEEE)
val DefaultBackground = Color(0xEBEBEBEB)
val HintGray = Color(0xFF8B8B8B)



val Blue200 = Color(0xFF73e8ff)
val Blue500 = Color(0xFF29b6f6)
val Blue700 = Color(0xFF0086c3)
val Teal200 = Color(0xFF03DAC5)


val md_theme_light_primary = Color(0xFFA42A29)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFFFD9E2)
val md_theme_light_onPrimaryContainer = Color(0xFF3E001D)
val md_theme_light_secondary = Color(0xFF984063)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFFFD9E3)
val md_theme_light_onSecondaryContainer = Color(0xFF3E001F)
val md_theme_light_tertiary = Color(0xFF984061)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFFD9E2)
val md_theme_light_onTertiaryContainer = Color(0xFF3E001D)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFFFFFF)
val md_theme_light_onBackground = Color(0xFF201A1B)
val md_theme_light_surface = Color(0xFFFFFBFF)
val md_theme_light_onSurface = Color(0xFF201A1B)
val md_theme_light_surfaceVariant = Color(0xFFF2DDE1)
val md_theme_light_onSurfaceVariant = Color(0xFF514347)
val md_theme_light_outline = Color(0xFFE9EBEA)
val md_theme_light_inverseOnSurface = Color(0xFFFAEEEF)
val md_theme_light_inverseSurface = Color(0xFF352F30)
val md_theme_light_inversePrimary = Color(0xFFFFB1C8)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFFB31B63)
val md_theme_light_outlineVariant = Color(0xFFD5C2C6)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFDD5658)
val md_theme_dark_onPrimary = Color(0xFF650033)
val md_theme_dark_primaryContainer = Color(0xFF8E004A)
val md_theme_dark_onPrimaryContainer = Color(0xFFFFD9E2)
val md_theme_dark_secondary = Color(0xFFFFB0C9)
val md_theme_dark_onSecondary = Color(0xFF5D1134)
val md_theme_dark_secondaryContainer = Color(0xFF7A294B)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFD9E3)
val md_theme_dark_tertiary = Color(0xFFFFB0C8)
val md_theme_dark_onTertiary = Color(0xFF5E1133)
val md_theme_dark_tertiaryContainer = Color(0xFF7B2949)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFD9E2)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF21201E)
val md_theme_dark_onBackground = Color(0xFFEBE0E1)
val md_theme_dark_surface = Color(0xFF201A1B)
val md_theme_dark_onSurface = Color(0xFFEBE0E1)
val md_theme_dark_surfaceVariant = Color(0xFF514347)
val md_theme_dark_onSurfaceVariant = Color(0xFFD5C2C6)
val md_theme_dark_outline = Color(0xFF373737)
val md_theme_dark_inverseOnSurface = Color(0xFF201A1B)
val md_theme_dark_inverseSurface = Color(0xFFEBE0E1)
val md_theme_dark_inversePrimary = Color(0xFFB31B63)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFFFB1C8)
val md_theme_dark_outlineVariant = Color(0xFF514347)
val md_theme_dark_scrim = Color(0xFF000000)



val colorBackground
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.surface

val colorOnBackground
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.onSurface

val colorButton
    @Composable
    @ReadOnlyComposable
    get() =
        MaterialTheme.colorScheme.secondaryContainer

val colorOnButton
    @Composable
    @ReadOnlyComposable
    get() =
        MaterialTheme.colorScheme.onSurfaceVariant

val colorEditor
    @Composable
    @ReadOnlyComposable
    get() =
        MaterialTheme.colorScheme.surface

val colorOnEditor
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.onSurface


