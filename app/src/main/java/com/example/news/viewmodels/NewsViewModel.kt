package com.example.news.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.news.models.News
import com.example.news.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository): ViewModel() {
    private val _news= MutableStateFlow<News?>(null)
    val news: StateFlow<News?> get()=repository.news

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNews()
        }
    }


}