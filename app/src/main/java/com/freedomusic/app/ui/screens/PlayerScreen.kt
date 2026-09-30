package com.freedomusic.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.freedomusic.app.ui.components.glassmorphism

@Composable
fun PlayerScreen() {
    // A beautiful player screen taking advantage of the Glassmorphism modifier
    Box(modifier = Modifier.fillMaxSize()) {
        // Background - Normally would be the blurred album art
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
        )

        // Glass panel with controls
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)
                .glassmorphism(
                    shape = RoundedCornerShape(24.dp),
                    overlayColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f)
                )
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Track Info
            Text(
                text = "Currently Playing Track",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Artist Name",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Progress Bar
            Slider(
                value = 0.3f,
                onValueChange = { /* Seek */ },
                modifier = Modifier.fillMaxWidth()
            )

            // Controls
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Toggle Loop */ }) {
                    Icon(Icons.Filled.Refresh, contentDescription = "Loop")
                }
                IconButton(onClick = { /* Prev */ }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Previous")
                }
                FloatingActionButton(onClick = { /* Play/Pause */ }) {
                    Icon(Icons.Filled.PlayArrow, contentDescription = "Play/Pause")
                }
                IconButton(onClick = { /* Next */ }) {
                    Icon(Icons.Filled.ArrowForward, contentDescription = "Next")
                }
                IconButton(onClick = { /* Queue */ }) {
                    Icon(Icons.Filled.List, contentDescription = "Queue")
                }
            }
        }
    }
}
