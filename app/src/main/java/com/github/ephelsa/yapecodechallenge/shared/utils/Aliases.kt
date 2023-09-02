package com.github.ephelsa.yapecodechallenge.shared.utils

internal typealias VoidCallback = () -> Unit
internal typealias VoidCallbackWithReturn<T> = () -> T

internal typealias ResultCallback<T> = (result: T) -> Unit
internal typealias ResultCallbackWithReturn<T, G> = (result: T) -> G
