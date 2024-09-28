package com.example.news.utils

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
   class Success<T>(data: T) : Resource<T>(data)
   class Error<T>(throwable: Throwable? = null, data: T? = null, message: String?) :
       Resource<T>(data, message)


   class Loading<T>(data: T? = null) : Resource<T>(data)
}
