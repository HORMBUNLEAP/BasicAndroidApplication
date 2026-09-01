package com.leap.basicApp.commom

enum class CurrencyCode(val code: String) {
    KHR("៛"),
    USD("$")
}


enum class AccountTypeCode(val code: String){
    LOAN_ACCOUNT("1000"),
    DEPOSIT_ACCOUNT("2000"),
    SAVING_ACCOUNT("3000"),

}
enum class FreezeYN{
    Y,
    N
}

enum class CardTypeCode {
    VISA_CLASSIC,
    VISA_GOLD,
    VISA_PLATINUM
}

