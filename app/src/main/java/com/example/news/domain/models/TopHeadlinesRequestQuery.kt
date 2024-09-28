package com.example.news.domain.models

data class TopHeadlinesRequestQuery(
    val country: String? = null,
    val category: String? = null,
    val sources: String? = null,
    val q: String? = null,
    val pageSize: Int? = null,
    val page: Int? = null
)