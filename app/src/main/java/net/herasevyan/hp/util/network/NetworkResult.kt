package net.herasevyan.hp.util.network

sealed class NetworkResult<T> {
    class None<T> : NetworkResult<T>()
    class Loading<T> : NetworkResult<T>()
    class Success<T>(val data: T) : NetworkResult<T>()
    class Error<T>(val message: String) : NetworkResult<T>()
}

inline fun <T> NetworkResult<T>.onLoading(block: () -> Unit): NetworkResult<T> {
    if (this is NetworkResult.Loading) block()
    return this
}

inline fun <T> NetworkResult<T>.onSuccess(block: (T) -> Unit): NetworkResult<T> {
    if (this is NetworkResult.Success) block(data)
    return this
}

inline fun <T> NetworkResult<T>.onError(block: (String) -> Unit): NetworkResult<T> {
    if (this is NetworkResult.Error) block(message)
    return this
}