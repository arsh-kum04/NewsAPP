package com.example.news

import MainScreen
import NewsDetailScreen
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.news.ui.theme.NewsTheme
import com.example.news.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NewsTheme {
                NewsApp(newsViewModel = newsViewModel)
            }
        }
    }
}

@Composable
fun NewsApp(newsViewModel: NewsViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") {
            MainScreen(navController = navController, newsViewModel = newsViewModel)
        }
        composable("NewsDetailScreen/{title}") { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")
            val articles = newsViewModel.news.collectAsState().value?.articles ?: emptyList()
            val article = articles.find { it.title == title }
            article?.let {
                NewsDetailScreen(article = it)
            }
        }
    }
}
@Composable
fun EmptyStateScreen() {

    Text(text = "No articles available", modifier = Modifier.fillMaxSize().padding(16.dp))
}

@Composable
fun LoadingScreen() {
    Text(text = "Loading...", modifier = Modifier.fillMaxSize().padding(16.dp))
}
