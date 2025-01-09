package com.example.mybookfinderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.mybookfinderapp.screens.BookListScreen
import com.example.mybookfinderapp.ui.theme.MyBookFinderAppTheme
import com.example.mybookfinderapp.viewmodel.BookViewModel
import com.example.mybookfinderapp.viewmodel.BookViewModelFactory

class MainActivity : ComponentActivity() {
    private val bookViewModel: BookViewModel by viewModels {
        BookViewModelFactory((application as MyBookFinderApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBookFinderAppTheme {
                MainScreen(bookViewModel)
            }
        }

        bookViewModel.searchBooks("Kotlin")
    }
}

@Composable
fun MainScreen(bookViewModel: BookViewModel) {
    val books by bookViewModel.books.collectAsState()

    if (books.isEmpty()) {
        EmptyState()
    } else {
        BookListScreen(books = books, onBookClick = { book ->
        })
    }
}

@Composable
fun EmptyState() {
    androidx.compose.material3.Text(
        text = "No books found",
        modifier = Modifier.fillMaxSize()
    )
}
