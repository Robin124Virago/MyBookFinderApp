package com.example.mybookfinderapp.repository

import com.example.mybookfinderapp.database.BookDao
import com.example.mybookfinderapp.model.Book
import com.example.mybookfinderapp.network.RetrofitInstance

class BookRepository(private val bookDao: BookDao) {

    suspend fun searchBooks(query: String): List<Book> {
        val response = RetrofitInstance.api.searchBooks(query)
        val sanitizedBooks = response.docs.map { apiBook ->
            Book(
                id = apiBook.id ?: "Unknown ID",
                title = apiBook.title ?: "Unknown Title",
                author = apiBook.author_name?.joinToString(", ") ?: "Unknown Author", // Handle multiple authors
                coverImageUrl = apiBook.coverImageUrl ?: "",
                description = apiBook.description ?: "No Description Available"
            )
        }
        bookDao.insertBooks(sanitizedBooks)
        return sanitizedBooks
    }

    suspend fun getCachedBooks(): List<Book> {
        return bookDao.getBooks()
    }
}
