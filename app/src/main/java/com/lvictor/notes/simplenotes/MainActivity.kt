package com.lvictor.notes.simplenotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.lvictor.notes.simplenotes.framework.ListViewModel
import com.lvictor.notes.simplenotes.framework.NoteViewModel
import com.lvictor.notes.simplenotes.ui.navigation.NoteNavGraph
import com.lvictor.notes.simplenotes.ui.theme.SimpleNotesTheme

class MainActivity : ComponentActivity() {

    // todo inject
    private lateinit var viewModel: ListViewModel
    private lateinit var viewModelNote: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        viewModelNote = ViewModelProvider(this)[NoteViewModel::class.java]

        setContent {
            SimpleNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NoteNavGraph(rememberNavController())

                    // for testing/ debugging
//                    NotesScreen()
//                    NoteScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleNotesTheme {
    }
}