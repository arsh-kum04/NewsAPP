package com.example.news.api

import com.example.news.models.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "YOUR_API_KEY"
    ): Response<News>

    @GET("everything")
    suspend fun getBitcoinNews(
        @Query("q") query: String = "bitcoin",
        @Query("apiKey") apiKey: String = "YOUR_API_KEY"
    ): Response<News>
}