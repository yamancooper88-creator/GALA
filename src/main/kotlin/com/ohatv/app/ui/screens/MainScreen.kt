package com.ohatv.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MainScreen() {
    val selectedTab = remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // Header
            Text(
                text = "OhaTV - Android TV Streaming App",
                color = Color.White,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Navigation Tabs
            TvLazyRow(
                modifier = Modifier
                    .padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(
                    listOf("IPTV", "Browser", "Einstellungen"),
                    key = { it }
                ) { tab ->
                    Button(
                        onClick = { selectedTab.value = listOf("IPTV", "Browser", "Einstellungen").indexOf(tab) },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(tab)
                    }
                }
            }

            // Content Area
            when (selectedTab.value) {
                0 -> IPTVScreen()
                1 -> BrowserScreen()
                2 -> SettingsScreen()
            }
        }
    }
}

@Composable
fun IPTVScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "IPTV Player",
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "M3U-Playlisten-Unterstützung und Live-TV-Kanäle werden hier angezeigt.",
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun BrowserScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Browser",
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Spezialisierter Browser mit Video-Erkennung und Ad-Blocking.",
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Einstellungen",
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "App-Konfiguration und Benutzereinstellungen.",
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}
