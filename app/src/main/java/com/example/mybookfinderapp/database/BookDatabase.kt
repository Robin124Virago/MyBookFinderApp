package com.example.mybookfinderapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mybookfinderapp.model.Book

@Database(entities = [Book::class], version = 1)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}
