package com.example.news.data.remote

import com.example.news.data.api.NewsAPI
import com.example.news.data.models.NewsResponse
import com.example.news.utils.Resource
import com.example.news.utils.safeApiCall
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsAPI
):NewsRepository{
    override suspend fun getTopHeadlines(
        country: String,
        category: String,
        sources: String,
        query: String,
        page: Int,
        pageSize: Int
    ): Resource<NewsResponse> {
        return safeApiCall {
            api.getTopHeadlines(country, category, sources, query, page, pageSize)
        }
    }

    override suspend fun getEverything(
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
    ): Resource<NewsResponse> {
      return safeApiCall {
          api.getEverything(query, searchIn, sources, domains, excludeDomains, from, to, language, sortBy, pageSize, page)
      }
    }

}