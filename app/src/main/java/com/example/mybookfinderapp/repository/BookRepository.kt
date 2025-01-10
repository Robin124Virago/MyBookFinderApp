package com.example.mybookfinderapp.repository

import com.example.mybookfinderapp.database.BookDao
import com.example.mybookfinderapp.model.Book
import com.example.mybookfinderapp.network.RetrofitInstance

class BookRepository(private val bookDao: BookDao) {

    suspend fun searchBooks(query: String): List<Book> {
        val response = RetrofitInstance.api.searchBooks(query)
        val sanitizedBooks = response.docs.map { book ->
            Book(
                id = book.id ?: "Unknown ID",
                title = book.title ?: "Unknown Title",
                author = book.author ?: "Unknown Author",
                coverImageUrl = book.coverImageUrl ?: "",
                description = book.description ?: "No Description Available"
            )
        }
        bookDao.insertBooks(sanitizedBooks) // Cache the books locally
        return sanitizedBooks
    }

    suspend fun getCachedBooks(): List<Book> {
        return bookDao.getBooks()
    }
}
