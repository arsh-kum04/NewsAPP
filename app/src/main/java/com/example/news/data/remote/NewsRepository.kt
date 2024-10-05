package com.example.news.data.remote

import com.example.news.data.models.NewsResponse
import com.example.news.utils.Resource

interface NewsRepository {
    suspend fun getTopHeadlines(
        country: String,
        category: String,
        sources: String,
        query: String,
        page: Int,
        pageSize: Int
    ): Resource<NewsResponse>

    suspend fun getEverything(
        query: String,
        searchIn: String,
        sources: String,
        domains: String,
        excludeDomains: String,
        from: String,
        to: String,
        language: String,
        sortBy: String,
        pageSize: Int,
        page: Int
    ): Resource<NewsResponse>
}