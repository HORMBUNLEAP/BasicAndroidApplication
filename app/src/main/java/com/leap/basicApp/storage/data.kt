package com.leap.basicApp.storage

import com.leap.basicApp.commom.AccountTypeCode
import com.leap.basicApp.commom.CardTypeCode
import com.leap.basicApp.commom.CurrencyCode
import com.leap.basicApp.commom.FreezeYN
import com.leap.basicApp.model.AccountModel
import com.leap.basicApp.model.VisaCardModel

//
//val accountArray = arrayOf(
//    AccountModel(
//        accountNo = "100000001",
//        accountTyoe = AccountTypeCode.DEPOSIT_ACCOUNT,
//        currencyCode = CurrencyCode.USD,
//        availableBalance = 1500.50,
//        freezeYN =      FreezeYN.N
//    ),
//    AccountModel(
//        accountNo = "100000002",
//        accountTyoe = AccountTypeCode.DEPOSIT_ACCOUNT,
//        currencyCode = CurrencyCode.KHR,
//        availableBalance = 2500000.0,
//        freezeYN = FreezeYN.N
//    ),
//    AccountModel(
//        accountNo = "100000003",
//        accountTyoe = AccountTypeCode.SAVING_ACCOUNT,
//        currencyCode = CurrencyCode.USD,
//        availableBalance = -12000.0,
//        freezeYN = FreezeYN.Y
//    ),
//    AccountModel(
//        accountNo = "100000004",
//        accountTyoe = AccountTypeCode.DEPOSIT_ACCOUNT,
//        currencyCode = CurrencyCode.USD,
//        availableBalance = 9800.75,
//        freezeYN = FreezeYN.N
//    ),
//    AccountModel(
//        accountNo = "100000005",
//        accountTyoe = AccountTypeCode.SAVING_ACCOUNT,
//        currencyCode = CurrencyCode.USD,
//        availableBalance = 500.0,
//        freezeYN = FreezeYN.Y
//    ),
//    AccountModel(
//        accountNo = "100000006",
//        accountTyoe = AccountTypeCode.LOAN_ACCOUNT,
//        currencyCode = CurrencyCode.KHR,
//        availableBalance = 850000.0,
//        freezeYN = FreezeYN.N
//    ),
//    AccountModel(
//        accountNo = "100000007",
//        accountTyoe = AccountTypeCode.LOAN_ACCOUNT,
//        currencyCode = CurrencyCode.KHR,
//        availableBalance = -3500000.0,
//        freezeYN = FreezeYN.N
//    ),
//    AccountModel(
//        accountNo = "100000008",
//        accountTyoe = AccountTypeCode.LOAN_ACCOUNT,
//        currencyCode = CurrencyCode.KHR,
//        availableBalance = 12000.0,
//        freezeYN = FreezeYN.N
//    ),
//    AccountModel(
//        accountNo = "100000009",
//        accountTyoe = AccountTypeCode.SAVING_ACCOUNT,
//        currencyCode = CurrencyCode.USD,
//        availableBalance = 3200.25,
//        freezeYN = FreezeYN.Y
//    ),
//    AccountModel(
//        accountNo = "100000010",
//        accountTyoe = AccountTypeCode.LOAN_ACCOUNT,
//        currencyCode = CurrencyCode.USD,
//        availableBalance = 780.0,
//        freezeYN = FreezeYN.N
//    )
//)

val visaCardArray = arrayOf(
    VisaCardModel(
        cardNo = "4000000000000001",
        cardType = CardTypeCode.VISA_CLASSIC,
        cardHolderName = "John Doe",
        currencyCode = CurrencyCode.USD,
        expiryDate = "12/27",
        cvv = "123",
        availableBalance = 1500.50,
        freezeYN = FreezeYN.N
    ),
    VisaCardModel(
        cardNo = "4000000000000002",
        cardType = CardTypeCode.VISA_GOLD,
        cardHolderName = "Jane Smith",
        currencyCode = CurrencyCode.USD,
        expiryDate = "05/26",
        cvv = "456",
        availableBalance = 3200.00,
        freezeYN = FreezeYN.N
    ),
    VisaCardModel(
        cardNo = "4000000000000003",
        cardType = CardTypeCode.VISA_PLATINUM,
        cardHolderName = "Ali Reza",
        currencyCode = CurrencyCode.USD,
        expiryDate = "09/28",
        cvv = "789",
        availableBalance = 8700.25,
        freezeYN = FreezeYN.N
    ),
    VisaCardModel(
        cardNo = "4000000000000004",
        cardType = CardTypeCode.VISA_CLASSIC,
        cardHolderName = "Sokha Chan",
        currencyCode = CurrencyCode.KHR,
        expiryDate = "03/27",
        cvv = "111",
        availableBalance = 500000.00,
        freezeYN = FreezeYN.N
    ),
    VisaCardModel(
        cardNo = "4000000000000005",
        cardType = CardTypeCode.VISA_GOLD,
        cardHolderName = "Maria Garcia",
        currencyCode = CurrencyCode.USD,
        expiryDate = "07/29",
        cvv = "222",
        availableBalance = 950.75,
        freezeYN = FreezeYN.Y
    ),
    VisaCardModel(
        cardNo = "4000000000000006",
        cardType = CardTypeCode.VISA_CLASSIC,
        cardHolderName = "David Kim",
        currencyCode = CurrencyCode.USD,
        expiryDate = "01/28",
        cvv = "333",
        availableBalance = 2100.00,
        freezeYN = FreezeYN.N
    ),
    VisaCardModel(
        cardNo = "4000000000000007",
        cardType = CardTypeCode.VISA_PLATINUM,
        cardHolderName = "Emma Wilson",
        currencyCode = CurrencyCode.KHR,
        expiryDate = "11/27",
        cvv = "444",
        availableBalance = 15000.00,
        freezeYN = FreezeYN.N
    ),
    VisaCardModel(
        cardNo = "4000000000000008",
        cardType = CardTypeCode.VISA_GOLD,
        cardHolderName = "Rithy Vann",
        currencyCode = CurrencyCode.KHR,
        expiryDate = "06/26",
        cvv = "555",
        availableBalance = 750000.00,
        freezeYN = FreezeYN.N
    ),
    VisaCardModel(
        cardNo = "4000000000000009",
        cardType = CardTypeCode.VISA_CLASSIC,
        cardHolderName = "Sophea Long",
        currencyCode = CurrencyCode.USD,
        expiryDate = "10/28",
        cvv = "666",
        availableBalance = 320.40,
        freezeYN = FreezeYN.Y
    ),
    VisaCardModel(
        cardNo = "4000000000000010",
        cardType = CardTypeCode.VISA_PLATINUM,
        cardHolderName = "Michael Chen",
        currencyCode = CurrencyCode.USD,
        expiryDate = "02/29",
        cvv = "777",
        availableBalance = 22000.00,
        freezeYN = FreezeYN.N
    )
)