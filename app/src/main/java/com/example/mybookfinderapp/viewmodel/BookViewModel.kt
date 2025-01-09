package com.example.mybookfinderapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybookfinderapp.model.Book
import com.example.mybookfinderapp.repository.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books

    fun searchBooks(query: String) {
        viewModelScope.launch {
            _books.value = repository.searchBooks(query)
        }
    }

    fun loadCachedBooks() {
        viewModelScope.launch {
            _books.value = repository.getCachedBooks()
        }
    }
}
