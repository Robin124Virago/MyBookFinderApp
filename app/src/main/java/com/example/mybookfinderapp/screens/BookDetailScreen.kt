package com.example.mybookfinderapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mybookfinderapp.model.Book

@Composable
fun BookDetailScreen(book: Book) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = book.title ?: "Unknown Title",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "By ${book.author ?: "Unknown Author"}",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = book.description ?: "No description available",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

