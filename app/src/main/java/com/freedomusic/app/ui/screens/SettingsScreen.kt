package com.freedomusic.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Settings") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Theme", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            // Theme selection stub
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Button(onClick = { }) { Text("Black") }
                Button(onClick = { }) { Text("Pink") }
                Button(onClick = { }) { Text("Glass") }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Audio Engine", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            // Engine selection stub
            Column {
                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    RadioButton(selected = true, onClick = { })
                    Text("Simple Crossfade")
                }
                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    RadioButton(selected = false, onClick = { })
                    Text("DJ Complex (Beatmatching)")
                }
                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    RadioButton(selected = false, onClick = { })
                    Text("None")
                }
            }
        }
    }
}
