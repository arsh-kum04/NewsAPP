package com.example.news.di

import com.example.news.data.remote.NewsRepository
import com.example.news.data.remote.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun NewsRepository(repo: NewsRepositoryImpl): NewsRepository

}