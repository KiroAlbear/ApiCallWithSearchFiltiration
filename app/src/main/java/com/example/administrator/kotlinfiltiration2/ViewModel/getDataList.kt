package com.example.administrator.kotlinfiltiration2.ViewModel

import com.example.administrator.kotlinfiltiration2.Model.Currency
import java.util.*

interface getDataList {

    fun onDataRecieved(list: List<Currency.Companion.Datum>)
}