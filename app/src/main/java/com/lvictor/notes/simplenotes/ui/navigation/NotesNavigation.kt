package com.lvictor.notes.simplenotes.ui.navigation

import androidx.navigation.NavHostController
import com.lvictor.notes.core.data.Note

object Routes {
    const val HOME = "home"
    const val NOTE = "note"
}

class NotesActions(navHostController: NavHostController) {
    val goToNotesList: () -> Unit = {
        navHostController.navigate(Routes.HOME)
    }

    val goToNote: (Note?) -> Unit = {
        navHostController.navigate(Routes.NOTE)
    }
}