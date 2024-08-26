package com.example.news.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "News")
data class NewsEntity (
    @PrimaryKey(autoGenerate = true)val id: Int=0,
    val author: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String,
    val isFavourite:Boolean
)