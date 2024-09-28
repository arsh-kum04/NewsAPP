package com.example.news.data.api

import com.example.news.data.models.NewsResponse
import com.example.news.utils.NetworkConfig.EVERYTHING
import com.example.news.utils.NetworkConfig.TOP_HEADLINES
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET(TOP_HEADLINES)
    suspend fun getTopHeadlines(
        @Query("country") country: String? = null,
        @Query("category") category: String? = null,
        @Query("sources") sources: String? = null,
        @Query("query") query: String? = null,
        @Query("pageSize") pageSize: Int? = null,
        @Query("page") page: Int? = null,
    ): NewsResponse

    @GET(EVERYTHING)
    suspend fun getEverything(
        @Query("query") query: String? = null,
        @Query("searchIn") searchIn: String? = null,
        @Query("sources") sources: String? = null,
        @Query("domains") domains: String? = null,
        @Query("excludeDomains") excludeDomains: String? = null,
        @Query("from") from: String? = null,
        @Query("to") to: String? = null,
        @Query("language") language: String? = null,
        @Query("sortBy") sortBy: String? = null,
        @Query("pageSize") pageSize: Int? = null,
        @Query("page") page: Int? = null,
    ): NewsResponse
}