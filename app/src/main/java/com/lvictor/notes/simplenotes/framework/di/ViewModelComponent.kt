package com.lvictor.notes.simplenotes.framework.di

import com.lvictor.notes.simplenotes.framework.ListViewModel
import com.lvictor.notes.simplenotes.framework.NoteViewModel
import dagger.Component


@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCaseModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}