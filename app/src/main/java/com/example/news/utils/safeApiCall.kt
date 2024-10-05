package com.example.news.utils

import com.google.gson.JsonParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun <T> safeApiCall(
    maxRetries: Int = 3,
    retryDelayMillis: Long = 1000,
    apiCall: suspend () -> T,
): Resource<T> {
    return withContext(Dispatchers.IO) {
        var currentAttempt = 0
        var result: Resource<T>
        while (true) {
            try {
                result = Resource.Success(apiCall.invoke())
                break
            } catch (throwable: Throwable) {
                currentAttempt++

                if (throwable is HttpException && throwable.code() in listOf(400, 401, 500, 502)) {
                    val errorMessage = extractErrorMessage(throwable)

                    if (currentAttempt >= maxRetries) {
                        result = Resource.Error(throwable, null, errorMessage)
                        break
                    } else {
                        delay(retryDelayMillis) // Delay before retrying
                    }
                } else {
                    result = Resource.Error(throwable, null, throwable.message ?: "Unknown error")
                    break
                }
            }
        }
        result
    }
}

fun extractErrorMessage(throwable: HttpException): String {
    return try {
        throwable.response()?.errorBody()?.string()?.let { errorBody ->
            val jsonObject = JsonParser().parse(errorBody).asJsonObject
            val status = jsonObject.get("status")?.asString ?: "Unknown status"
            val code = jsonObject.get("code")?.asString ?: "Unknown error code"
            val message = jsonObject.get("message")?.asString ?: "No error message available"

            "Status: $status, Code: $code, Message: $message"
        } ?: "Empty error body"
    } catch (e: Exception) {
        "Error parsing error response"
    }
}
