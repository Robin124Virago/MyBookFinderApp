package com.example.mybookfinderapp.network

import com.example.mybookfinderapp.model.BookResponse
import retrofit2.http.GET
import retrofit2.http.Query
interface BookApiService {
    @GET("search.json")
    suspend fun searchBooks(@Query("q") query: String): BookResponse
}
