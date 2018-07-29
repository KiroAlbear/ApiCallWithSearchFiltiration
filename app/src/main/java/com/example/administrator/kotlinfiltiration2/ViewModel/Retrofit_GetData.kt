package com.example.administrator.kotlinfiltiration2.ViewModel

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.example.administrator.kotlinfiltiration2.Model.Currency
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit_GetData(context: Context, getdatalist: getDataList) {

    var context = context
    //    var currencyadapter = currencyadapter
//    var searchcurrency = searchCurrency
    var currencyresponse: List<Currency.Datum>? = null
    var getdatalist: getDataList? = getdatalist

    init {
        currencyresponse = arrayListOf<Currency.Datum>()
    }

    fun getData() {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.coinmarketcap.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val request = retrofit.create(CurrencyApi::class.java)

        var call: Call<Currency> = request.getcurrency()

        call.enqueue(object : Callback<Currency> {
            override fun onFailure(call: Call<Currency>?, t: Throwable?) {

                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Currency>?, response: Response<Currency>?) {

                currencyresponse = response!!.body()!!.data!!
                getdatalist!!.onDataRecieved(currencyresponse!!)

                // var currencies = currencyresponse!!.data.
                //  currencyadapter = CurrancyAdapter(currencyresponse)
//                myRecycleView.layoutManager = GridLayoutManager(applicationContext, 1)
//                myRecycleView.adapter = currencyAdapter

                //  searchcurrency = SearchCurrency(applicationContext, myRecycleView, currencyAdapter)

                //  currencydatabase = SaveToDataBase(applicationContext, currencyresponse)
                //  currencydatabase!!.savetodataase()

                //  Toast.makeText(applicationContext, currencyresponse!![2].name,Toast.LENGTH_SHORT).show()


            }
        })


    }
}