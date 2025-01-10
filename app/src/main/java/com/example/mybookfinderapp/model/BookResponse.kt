package com.example.mybookfinderapp.model

data class BookResponse(
    val docs: List<ApiBook>
)

data class ApiBook(
    val id: String?,
    val title: String?,
    val author_name: List<String>?,
    val coverImageUrl: String?,
    val description: String?
)