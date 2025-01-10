package com.example.mybookfinderapp

import BookDetailScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybookfinderapp.screens.BookListScreen
import com.example.mybookfinderapp.ui.theme.MyBookFinderAppTheme
import com.example.mybookfinderapp.viewmodel.BookViewModel
import com.example.mybookfinderapp.viewmodel.BookViewModelFactory
import com.example.mybookfinderapp.navigation.Screen
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private val bookViewModel: BookViewModel by viewModels {
        BookViewModelFactory((application as MyBookFinderApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBookFinderAppTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(navController, bookViewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController, bookViewModel: BookViewModel) {
    val books by bookViewModel.books.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                if (query.isNotEmpty()) {
                    bookViewModel.searchBooks(query)
                } else {
                    bookViewModel.loadCachedBooks()
                }
            },
            label = { Text("Search Books") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        NavHost(
            navController = navController,
            startDestination = Screen.BookList.route
        ) {
            composable(Screen.BookList.route) {
                BookListScreen(
                    books = books,
                    onBookClick = { book ->
                        navController.navigate(Screen.BookDetail.createRoute(book.id))
                    }
                )
            }
            composable(Screen.BookDetail.route) { backStackEntry ->
                val bookId = backStackEntry.arguments?.getString("bookId")
                val book = books.find { it.id == bookId }
                book?.let {
                    BookDetailScreen(book = it)
                }
            }
        }
    }
}

