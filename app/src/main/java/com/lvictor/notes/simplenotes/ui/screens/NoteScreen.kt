package com.lvictor.notes.simplenotes.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.lvictor.notes.core.data.Note

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(note: Note? = null) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {},
        floatingActionButton = {
            FloatingActionButton(onClick = { }, shape = CircleShape, containerColor = Color.Cyan) {
                Icon(Icons.Filled.Check, "")
            }
        },
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            val title = remember {
                mutableStateOf(note?.title ?: "")
            }
            val content = remember {
                mutableStateOf(note?.content ?: "")
            }

            TextField(
                value = title.value,
                onValueChange = { title.value = it },
                singleLine = true, maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Title") }
            )
            TextField(
                value = content.value,
                onValueChange = { content.value = it },
                singleLine = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1.0f),
                placeholder = { Text("Content") }
            )
        }
    }
}

@Preview
@Composable
fun PreviewNoteScreen() {
    NoteScreen(null)
}
