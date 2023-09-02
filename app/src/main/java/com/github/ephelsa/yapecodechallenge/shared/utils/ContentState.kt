package com.github.ephelsa.yapecodechallenge.shared.utils

internal sealed class ContentState<T>(
    val isLoading: Boolean,
    val result: Result<T>?,
) {
    class Init<T> : ContentState<T>(false, null)
    class Loading<T> : ContentState<T>(true, null)
    data class ContentReady<T>(private val content: Result<T>) : ContentState<T>(false, content)
}
