package com.lvictor.notes.core.repository

import com.lvictor.notes.core.data.Note
import com.lvictor.notes.core.repository.NoteDataSource

class NoteRepository(private val dataSource: NoteDataSource) {

    suspend fun addNote(note: Note) = dataSource.add(note)

    suspend fun getNote(id: Long) = dataSource.get(id)

    suspend fun getAllNotes() = dataSource.getAll()

    suspend fun removeNote(note: Note) = dataSource.remove(note)
}