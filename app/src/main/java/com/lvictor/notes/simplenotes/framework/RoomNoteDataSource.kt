package com.lvictor.notes.simplenotes.framework

import android.content.Context
import com.lvictor.notes.core.data.Note
import com.lvictor.notes.core.repository.NoteDataSource
import com.lvictor.notes.simplenotes.framework.db.DatabaseService
import com.lvictor.notes.simplenotes.framework.db.NoteEntity

class RoomNoteDataSource(context: Context): NoteDataSource {

    private val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long): Note? = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll(): List<Note> = noteDao.getAllNoteEntities().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}