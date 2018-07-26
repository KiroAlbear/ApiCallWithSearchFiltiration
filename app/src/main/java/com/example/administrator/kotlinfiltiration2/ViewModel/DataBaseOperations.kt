package com.example.administrator.kotlinfiltiration2.ViewModel

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


import com.example.administrator.kotlinfiltiration2.Model.Currency
import java.util.*


@Dao
interface DataBaseOperations {

    @Insert
    fun addcurrency(currency: Currency.Datum)

    @Query("select * from currencytable")
    fun getallcurrencies(): List<Currency.Datum>

    @Query("SELECT COUNT(*) FROM currencytable")
    fun tablesize():Int

    @Query("SELECT * FROM currencytable where name like :currencyname" )
    fun searchcurrency(currencyname:String): List<Currency.Datum>

}