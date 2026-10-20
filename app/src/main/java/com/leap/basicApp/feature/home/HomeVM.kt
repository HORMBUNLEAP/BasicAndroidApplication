package com.leap.basicApp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leap.basicApp.model.BaseUiState
import com.leap.basicApp.model.ComponentModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeVM(
    private val homeRepository: HomeRepository = HomeRepository()
): ViewModel() {
    private var _componentList : MutableStateFlow<BaseUiState<List<ComponentModel>>?> =
        MutableStateFlow(BaseUiState.Loading)
    var componentList = _componentList.asStateFlow()
    fun getComponentList(){
        viewModelScope.launch {
            _componentList.emit(
                BaseUiState.Loading
            )
            homeRepository.GetComponentList().collect {
                _componentList.emit(BaseUiState.Success(it))
            }
        }
    }
    init {
        getComponentList()
    }
    fun onDispose(){
        viewModelScope.cancel()
        _componentList.value = BaseUiState.None
    }
}