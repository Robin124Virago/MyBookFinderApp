package com.example.mybookfinderapp.navigation

sealed class Screen(val route: String) {
    object BookList : Screen("bookList")
    object BookDetail : Screen("bookDetail/{bookId}") {
        fun createRoute(bookId: String) = "bookDetail/$bookId"
    }
}
