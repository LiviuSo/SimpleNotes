package com.lvictor.notes.simplenotes.ui.screens

import androidx.compose.runtime.Composable
import com.lvictor.notes.core.data.Note
import com.lvictor.notes.simplenotes.framework.NoteViewModel

@Composable
fun NoteScreen(viewModel: NoteViewModel) {
    viewModel.saveNote(
        Note(
            title = "Test note",
            content = "This is a dummy note",
            creationTime = 1687177910284,
            updateTime = 1687177910284
        )
    )
    viewModel.saveNote(
        Note(
            title = "Parinti si copii",
            content = "Piesa de teatru dupa romanul lui Tuegheniev",
            creationTime = 1687178024938,
            updateTime = 1687178024938
        )
    )
}

