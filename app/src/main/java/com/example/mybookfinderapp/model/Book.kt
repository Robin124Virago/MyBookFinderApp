package com.example.mybookfinderapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey val id: String,
    val title: String,
    val author: String,
    val coverImageUrl: String,
    val description: String
)