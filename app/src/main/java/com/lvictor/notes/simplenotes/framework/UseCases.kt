package com.lvictor.notes.simplenotes.framework

import com.lvictor.notes.core.usecase.AddNote
import com.lvictor.notes.core.usecase.GetAllNotes
import com.lvictor.notes.core.usecase.GetNote
import com.lvictor.notes.core.usecase.GetWordCount
import com.lvictor.notes.core.usecase.RemoveNote


data class UseCases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    val getWordCount: GetWordCount
)