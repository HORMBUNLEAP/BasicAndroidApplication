package com.leap.basicApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leap.basicApp.model.ReceiverAccountModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ToolTipViewModel: ViewModel() {
    private val accountInfo = ReceiverAccountModel(
        accountName = "Leap",
        accountNumber = "1001",
        receiverAccount = "Meng"
    )
    private val _receiver = MutableStateFlow<ReceiverAccountModel?>(null)
    val receiverAccount = _receiver.asStateFlow()

    fun getAccountInfo(){
       viewModelScope.launch {
           _receiver.emit(accountInfo  )
       }
    }
 }