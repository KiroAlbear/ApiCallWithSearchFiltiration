package com.example.administrator.kotlinfiltiration2.ViewModel


import android.icu.util.Currency
import io.reactivex.Observable


import retrofit2.Call;
import retrofit2.Callback
import retrofit2.http.GET;

import kotlin.collections.ArrayList

interface CurrencyApi {

    @GET("/v2/listings/")
    fun getcurrency():Call<com.example.administrator.kotlinfiltiration2.Model.Currency>
}