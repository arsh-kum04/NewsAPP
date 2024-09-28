package com.example.news.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.models.NewsResponse
import com.example.news.data.remote.NewsRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repo: NewsRepository): ViewModel() {
    private val _news= MutableStateFlow<NewsResponse?>(null)
    val news: StateFlow<NewsResponse?> get()=_news

    init {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }


}