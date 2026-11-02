package com.leap.basicApp.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leap.basicApp.model.BaseUiState
import com.leap.basicApp.model.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserVM(
    private val userRepository: UserRepository = UserRepository()
) : ViewModel(){
    private val _userUiState : MutableStateFlow<BaseUiState<UserModel?>> = MutableStateFlow(BaseUiState.None)
    val userUiState = _userUiState.asStateFlow()



    fun getUserDetail(id: Int){
        viewModelScope.launch {
            _userUiState.emit(BaseUiState.Loading)
            userRepository.getUserById(id).collect{response->
                if(response != null){
                    _userUiState.emit(BaseUiState.Success(response))
                }else
                {
                    _userUiState.emit(BaseUiState.Error(message = "User Not Found!"))
                }


            }
        }
    }
}