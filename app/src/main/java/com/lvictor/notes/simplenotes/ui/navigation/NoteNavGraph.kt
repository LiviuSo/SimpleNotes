package com.lvictor.notes.simplenotes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lvictor.notes.simplenotes.ui.screens.NoteScreen
import com.lvictor.notes.simplenotes.ui.screens.NotesScreen

@Composable
fun NoteNavGraph(
    navController: NavHostController
) {
    val actions = remember {
        NotesActions(navController)
    }

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            NotesScreen(actions.goToNote)
        }
        composable(Routes.NOTE) {
            NoteScreen()
        }
    }
}