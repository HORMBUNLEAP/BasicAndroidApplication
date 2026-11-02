package com.leap.basicApp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leap.basicApp.model.BaseUiState
import com.leap.basicApp.model.ComponentModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeVM(
    private val homeRepository: HomeRepository = HomeRepository()
) : ViewModel() {

    private val _componentList = MutableStateFlow<BaseUiState<List<ComponentModel>>?>(BaseUiState.Loading)
    val componentList = _componentList.asStateFlow()

    init {
        getComponentList()
    }

    fun getComponentList() {
        viewModelScope.launch {
            _componentList.emit(BaseUiState.Loading)
            homeRepository.GetComponentList().collect { items ->
                _componentList.emit(BaseUiState.Success(items))
            }
        }
    }

    fun onDispose() {
        // Note: Avoid calling viewModelScope.cancel() here unless you intend
        // to permanently kill the ViewModel scope because onDispose() can
        // trigger during recompositions/screen transitions.
        // viewModelScope is automatically canceled when the ViewModel is cleared.
        _componentList.value = BaseUiState.None
    }
}