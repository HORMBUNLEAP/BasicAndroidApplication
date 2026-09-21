package com.leap.basicApp.feature.badge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leap.basicApp.model.BaseUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BadgeViewModel: ViewModel() {
    private var _messageUiState: MutableStateFlow<BaseUiState<String>> =
        MutableStateFlow(BaseUiState.None)

    val messageUiState = _messageUiState.asStateFlow()

    fun requestData(){
        viewModelScope.launch {

            _messageUiState.value = BaseUiState.Loading
            delay(3000)
            _messageUiState.emit(BaseUiState.Success("This is message from server."))
        }
    }

}