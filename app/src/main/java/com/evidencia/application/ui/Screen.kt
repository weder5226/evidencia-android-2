package com.evidencia.application.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : Screen("home", "Inicio", Icons.Filled.Home)
    object Products : Screen("products", "Productos", Icons.Filled.Star)
    object Info : Screen("info", "Información", Icons.Filled.Info)
}
