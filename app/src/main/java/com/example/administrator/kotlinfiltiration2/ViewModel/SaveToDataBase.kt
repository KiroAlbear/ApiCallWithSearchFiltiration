package com.example.administrator.kotlinfiltiration2.ViewModel

import android.arch.persistence.room.Room
import android.content.Context
import android.widget.Toast
import com.example.administrator.kotlinfiltiration2.Model.Currency
import com.example.administrator.kotlinfiltiration2.Model.currencyDataBase
import java.util.*

class SaveToDataBase {
    var context: Context? = null
    var currencylist: List<Currency.Companion.Datum>? = null
    var roomdatabase: currencyDataBase? = null

    constructor(context: Context, currencylist: List<Currency.Companion.Datum>?) {
        this.context = context
        this.currencylist = currencylist

        roomdatabase = Room.databaseBuilder(context, currencyDataBase::class.java, "Currencydb").allowMainThreadQueries().build()
    }

    fun savetodataase() {

        for (i in currencylist!!) {
            roomdatabase!!.databaseoperation().addcurrency(i)

        }
        Toast.makeText(context, "Currencies Saved", Toast.LENGTH_SHORT).show()
    }

    fun GetTableSize():Int{
        return roomdatabase!!.databaseoperation().tablesize()
    }

    fun GetAllData():List<Currency.Companion.Datum>{
        return roomdatabase!!.databaseoperation().getallcurrencies()
    }






}