package com.lvictor.notes.simplenotes.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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

@Composable
private fun NotesList(notes: List<Note>) {
    LazyColumn(modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp)) {
        for (note in notes) {
            item {
                NoteItem(note)
            }
        }
    }
}

@Composable
private fun NoteItem(note: Note) {
    val sdf = remember {
        SimpleDateFormat("MMM dd, HH:mm:ss", Locale.getDefault())
    }
    val resultDate = remember {
        Date(note.updateTime)
    }
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(start = 5.dp, top = 0.dp, end = 5.dp, bottom = 5.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {


        Column(Modifier.background(color = Color.White).padding(5.dp)) {
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
            Box(modifier = Modifier.fillMaxWidth().padding(top = 20.dp)) {
                Text(
                    text = "Last updated: ${sdf.format(resultDate)}",
                    modifier = Modifier.wrapContentWidth().align(androidx.compose.ui.Alignment.CenterStart),
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontStyle = FontStyle.Normal
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
                Text(
                    text = "Words: ${note.wordCount}",
                    modifier = Modifier.wrapContentWidth().align(androidx.compose.ui.Alignment.CenterEnd),
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
    NoteItem(note = note)
}