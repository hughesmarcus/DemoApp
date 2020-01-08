package com.example.mailchimpapplication.utils

import retrofit2.Response
import java.util.concurrent.CancellationException

suspend fun <T> safeCall(call: suspend () -> Response<T>): T? {
    return try {
        call.invoke().body()
    } catch (e: Throwable) {
        // error handling
        if (e is CancellationException) { // allow coroutines to cancel
            throw e
        } else {
            null
        }
    }
}