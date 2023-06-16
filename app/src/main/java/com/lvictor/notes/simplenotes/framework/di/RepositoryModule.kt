package com.lvictor.notes.simplenotes.framework.di

import android.app.Application
import com.lvictor.notes.core.repository.NoteRepository
import com.lvictor.notes.simplenotes.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}