package com.lvictor.notes.core.usecase

import com.lvictor.notes.core.data.Note
import com.lvictor.notes.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)
}