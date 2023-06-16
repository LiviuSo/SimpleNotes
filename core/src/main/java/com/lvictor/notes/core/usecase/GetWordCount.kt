package com.lvictor.notes.core.usecase

import com.lvictor.notes.core.data.Note

class GetWordCount {
    operator fun invoke(note: Note): Int {
        return getCount(note.title) + getCount(note.content)
    }

    private fun getCount(str: String) = str.split(" ", "\n").count {
        it.contains(Regex(".*[a-zA-Z].*"))
    }
}