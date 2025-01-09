package com.example.mybookfinderapp

import android.app.Application
import androidx.room.Room
import com.example.mybookfinderapp.database.BookDatabase
import com.example.mybookfinderapp.repository.BookRepository

class MyBookFinderApplication : Application() {
    val database: BookDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            BookDatabase::class.java,
            "book_database"
        ).build()
    }

    val repository: BookRepository by lazy {
        BookRepository(database.bookDao())
    }
}
