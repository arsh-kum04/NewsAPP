package com.example.news.domain.models

data class EverythingRequestQuery(
    val query: String,
    val searchIn: String,
    val sources: String,
    val domains: String,
    val excludeDomains: String,
    val from: String,
    val to: String,
    val language: String,
    val sortBy: String,
    val pageSize: Int,
    val page: Int
)
