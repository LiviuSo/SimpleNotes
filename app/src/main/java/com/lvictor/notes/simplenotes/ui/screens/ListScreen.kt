package com.lvictor.notes.simplenotes.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lvictor.notes.core.data.Note
import com.lvictor.notes.simplenotes.framework.ListViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

val notes = arrayListOf(
    Note("title", "content", creationTime = 1687529553250, updateTime = 1687529553250, id = 0, wordCount = 1),
    Note("title", "content", creationTime = 1687529553250, updateTime = 1687529553250, id = 1, wordCount = 1),
    Note("title", "content", creationTime = 1687529553250, updateTime = 1687529553250, id = 2, wordCount = 1),
    Note("title", "content", creationTime = 1687529553250, updateTime = 1687529553250, id = 3, wordCount = 1),

    )

@Composable
fun NotesScreen(viewModel: ListViewModel) {
    NotesList(notes = notes)
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun NotesList(notes: List<Note>) {
    val onItemClicked: (Note) -> Unit = {
        // navigation
        Log.d("liviu", "clicked on $it")
    }
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {},
        floatingActionButton = {
            FloatingActionButton(onClick =  { /*navigation */ }, shape = CircleShape, containerColor = Color.Cyan) {
                Icon(Icons.Default.Edit, "")
            }
        }) {
        LazyColumn(modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp)) {
            for (note in notes) {
                item {
                    NoteItem(note, onItemClicked)
                }
            }
        }
    }
}

@Composable
private fun NoteItem(note: Note, onItemClicked: (Note) -> Unit) {
    val sdf = remember {
        SimpleDateFormat("MMM dd, HH:mm:ss", Locale.getDefault())
    }
    val resultDate = remember {
        Date(note.updateTime)
    }
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(start = 5.dp, top = 0.dp, end = 5.dp, bottom = 5.dp)
            .clickable {
                onItemClicked(note)
            },
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {


        Column(
            Modifier
                .background(color = Color.White)
                .padding(5.dp)
        ) {
            Text(
                text = note.title,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = note.content,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Normal
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis

            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = "Last updated: ${sdf.format(resultDate)}",
                    modifier = Modifier
                        .wrapContentWidth()
                        .align(androidx.compose.ui.Alignment.CenterStart),
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontStyle = FontStyle.Normal
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
                Text(
                    text = "Words: ${note.wordCount}",
                    modifier = Modifier
                        .wrapContentWidth()
                        .align(androidx.compose.ui.Alignment.CenterEnd),
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontStyle = FontStyle.Normal
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
            }
        }
    }
}

@Preview
@Composable
fun NoteItemPreview() {
    val note = Note("title", "content", creationTime = 1687529553250, updateTime = 1687529553250, id = 2, wordCount = 1)
    NoteItem(note = note) {}
}