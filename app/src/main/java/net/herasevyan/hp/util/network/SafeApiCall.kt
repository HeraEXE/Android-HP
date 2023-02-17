package net.herasevyan.hp.util.network

import retrofit2.Response

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
    try {
        val response = apiCall()
        if (response.isSuccessful) {
            response.body()?.let {
                return NetworkResult.Success(it)
            }
        }
        return NetworkResult.Error(response.message())
    } catch (e: Exception) {
        return NetworkResult.Error(e.message ?: "")
    }
}