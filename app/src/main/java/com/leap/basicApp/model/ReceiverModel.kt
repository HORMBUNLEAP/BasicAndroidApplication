package com.leap.basicApp.modelf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

public data class ReceiverAccountModel(
    val accountName: String,
    val accountNumber: String,
    val receiverAccount: String,
)

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