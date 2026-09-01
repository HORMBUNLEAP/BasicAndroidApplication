package com.leap.basicApp.model

import com.leap.basicApp.commom.AccountType
import com.leap.basicApp.commom.AccountTypeCode
import com.leap.basicApp.commom.CardTypeCode
import com.leap.basicApp.commom.CurrencyCode
import com.leap.basicApp.commom.FreezeYN


data class AccountModel(
    val accountNo : String,
    val accountType: AccountTypeCode,
    val currencyCode: CurrencyCode,
    val availableBalance: Double,
    val freezeYN: FreezeYN,
)
data class VisaCardModel(
    val cardNo: String,
    val cardType: CardTypeCode,
    val cardHolderName: String,
    val currencyCode: CurrencyCode,
    val expiryDate: String,
    val cvv: String,
    val availableBalance: Double,
    val freezeYN: FreezeYN
)