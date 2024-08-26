package com.example.news.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.news.api.NewsAPI
@Dao
interface NewsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNews(news:List<NewsEntity>)
    @Query("SELECT * FROM `News`")
    fun getAllNews(): LiveData<List<NewsEntity>>

    @Query("SELECT * FROM `News` WHERE isFavourite=1")
     fun getAllFavourites(): LiveData<List<NewsEntity>>
}