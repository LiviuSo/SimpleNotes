package com.lvictor.notes.simplenotes.framework.di

import com.lvictor.notes.core.repository.NoteRepository
import com.lvictor.notes.core.usecase.AddNote
import com.lvictor.notes.core.usecase.GetAllNotes
import com.lvictor.notes.core.usecase.GetNote
import com.lvictor.notes.core.usecase.GetWordCount
import com.lvictor.notes.core.usecase.RemoveNote
import com.lvictor.notes.simplenotes.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount()
    )
}