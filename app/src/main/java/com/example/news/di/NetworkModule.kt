package com.example.news.di

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.example.news.api.NewsAPI
import com.example.news.repository.NewsRepository
import com.example.news.roomdb.NewsDAO
import com.example.news.roomdb.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule{
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun providesNewsAPI(retrofit: Retrofit):NewsAPI{
        return retrofit.create(NewsAPI::class.java)
    }
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext appContext: Context): NewsDatabase {
        return Room.databaseBuilder(
            appContext.applicationContext,
            NewsDatabase::class.java,
            "News"
        ).fallbackToDestructiveMigration().build()
    }
    @Provides
    @Singleton
    fun providesRoomDB(db:NewsDatabase):NewsDAO{
        return db.newsdao()
    }


    companion object{
        val BASE_URL="https://newsapi.org/v2/"
    }
}