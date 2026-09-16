package com.leap.basicApp.model

sealed class BaseUiState <out T>  {
    data object None: BaseUiState<Nothing>()
    data object Loading: BaseUiState<Nothing>()
    data class Success<out T>(val data: T): BaseUiState<T>()
    data class Error(val message: String): BaseUiState<Nothing>()
    data class ErrorWithException(val message: String) : BaseUiState<Nothing>()
}