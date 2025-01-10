package com.example.mybookfinderapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mybookfinderapp.model.Book

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books: List<Book>)

    @Query("SELECT * FROM book")
    suspend fun getBooks(): List<Book>

    @Query("SELECT * FROM book WHERE title LIKE '%' || :searchQuery || '%'")
    suspend fun searchBooksByTitle(searchQuery: String): List<Book>
}
