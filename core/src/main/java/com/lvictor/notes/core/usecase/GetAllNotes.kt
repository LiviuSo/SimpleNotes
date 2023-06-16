package com.lvictor.notes.core.usecase

import com.lvictor.notes.core.repository.NoteRepository

class GetAllNotes(private val noteRepository: NoteRepository) {

    suspend operator fun invoke() = noteRepository.getAllNotes()
}