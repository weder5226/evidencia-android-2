package com.evidencia.application.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.evidencia.application.ui.theme.EmeraldGreen
import kotlinx.coroutines.launch

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val items = listOf(Screen.Home, Screen.Products, Screen.Info)
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(260.dp)
            ) {
                Spacer(Modifier.height(16.dp))
                items.forEach { screen ->
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = screen.title,
                                color = Color.Black,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.title,
                                tint = EmeraldGreen
                            )
                        },
                        selected = currentRoute == screen.route,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = EmeraldGreen.copy(alpha = 0.1f),
                            selectedIconColor = EmeraldGreen,
                            selectedTextColor = EmeraldGreen,
                            unselectedTextColor = Color.Black,
                            unselectedIconColor = EmeraldGreen
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

//                Admin Panel Item
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(Screen.Admin.title) },
                    icon = { Icon(Screen.Admin.icon, contentDescription = null) },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate(Screen.Admin.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = { Header(scope, drawerState) },
//            bottomBar = { Footer() }
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(padding)
            ) {
                composable(Screen.Home.route) { HomeScreen() }
                composable(Screen.Products.route) { ProductsScreen() }
                composable(Screen.Info.route) { InfoScreen() }
                composable(Screen.Admin.route) { AdminLoginScreen() }
            }
        }
    }
}
