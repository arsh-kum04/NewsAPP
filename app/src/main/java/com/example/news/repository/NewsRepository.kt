package com.example.news.repository

import com.example.news.api.NewsAPI
import com.example.news.models.News
import com.example.news.roomdb.NewsDAO
import com.example.news.roomdb.NewsEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsapi:NewsAPI,
    private val roomdao:NewsDAO) {

    private val _news= MutableStateFlow<News?>(null)
    val news: StateFlow<News?> get()=_news

    suspend fun getAllNews(){
        val result=newsapi.getTopHeadlines()
        if(result.isSuccessful && result.body()!=null){
            val newslist=result.body()?.articles?.map{
                article -> NewsEntity(
                author = article.author?:"Author",
                description = article.description?:"Author",
                publishedAt = article.publishedAt?:"Author",
                title = article.title?:"Author",
                url = article.url?:"Author",
                urlToImage = article.urlToImage?:"Author",
                isFavourite = false
                )
            }?: emptyList()

            insertAllNews(newslist)
            _news.emit(result.body())
        }

    }
    suspend fun insertAllNews(newslist:List<NewsEntity>){
        roomdao.insertNews(newslist)
    }

}