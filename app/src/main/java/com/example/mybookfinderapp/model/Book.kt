package com.example.mybookfinderapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey val id: String = "Unknown ID",
    val title: String = "Unknown Title",
    val author: String = "Unknown Author",
    val coverImageUrl: String = "",
    val description: String = "No Description Available"
)