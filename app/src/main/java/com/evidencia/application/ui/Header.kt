package com.evidencia.application.ui

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.core.net.toUri

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(scope: CoroutineScope, drawerState: DrawerState) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "DISORAYA PAGE",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch { drawerState.open() }
            }) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "Menú",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(35.dp)
                )
            }
        },
        actions = {
            val context = LocalContext.current
            IconButton(onClick = {
                val url = "https://www.whatsapp.com/"
                val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                context.startActivity(intent)
            }) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Contactar por WhatsApp",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(28.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}