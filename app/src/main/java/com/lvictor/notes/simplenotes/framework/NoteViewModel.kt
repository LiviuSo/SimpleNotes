package com.lvictor.notes.simplenotes.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.lvictor.notes.simplenotes.framework.di.ApplicationModule
import com.lvictor.notes.core.data.Note
import com.lvictor.notes.simplenotes.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    private val saved = MutableLiveData<Boolean?>()
    private val currentNote = MutableLiveData<Note?>()

    init {
        DaggerViewModelComponent.builder().applicationModule(ApplicationModule(getApplication())).build().inject(this)
    }

    fun saveNote(note: Note) {
        coroutineScope.launch {
            useCases.addNote(note)
            saved.postValue(true)
        }
    }

    fun getNote(id: Long) {
        coroutineScope.launch {
            currentNote.postValue(useCases.getNote(id))
        }
    }

    fun deleteNote(note: Note) {
        coroutineScope.launch {
            useCases.removeNote(note)
            saved.postValue(true)
        }
    }

    fun resetSaved() {
        saved.value = null
    }

    fun resetCurrentNote() {
        currentNote.value = null
    }
}