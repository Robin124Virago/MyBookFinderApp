package com.example.mybookfinderapp.repository

import com.example.mybookfinderapp.database.BookDao
import com.example.mybookfinderapp.model.Book
import com.example.mybookfinderapp.network.RetrofitInstance

class BookRepository(private val bookDao: BookDao) {

    suspend fun searchBooks(query: String): List<Book> {
        val response = RetrofitInstance.api.searchBooks(query)
        val books = response.docs
        bookDao.insertBooks(books) // Cache the books locally
        return books
    }

    suspend fun getCachedBooks(): List<Book> {
        return bookDao.getBooks()
    }
}
