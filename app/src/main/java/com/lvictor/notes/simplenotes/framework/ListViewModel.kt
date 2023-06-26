package com.lvictor.notes.simplenotes.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lvictor.notes.core.data.Note
import com.lvictor.notes.simplenotes.framework.di.ApplicationModule
import com.lvictor.notes.simplenotes.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    private val _notes = MutableLiveData<List<Note>>(arrayListOf())
    val notes: LiveData<List<Note>>
        get() = _notes

    init {
        DaggerViewModelComponent.builder().applicationModule(ApplicationModule(getApplication())).build().inject(this)
    }

    fun getNotes() {
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            noteList.forEach {
                it.wordCount = useCases.getWordCount(it)
            }
            _notes.postValue(noteList)
        }
    }
}