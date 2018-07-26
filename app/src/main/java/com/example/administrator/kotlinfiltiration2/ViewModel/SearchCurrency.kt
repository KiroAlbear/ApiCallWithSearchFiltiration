package com.example.administrator.kotlinfiltiration2.ViewModel

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.administrator.kotlinfiltiration2.Model.Currency

class SearchCurrency(context: Context, recycleview: RecyclerView, adaper: CurrancyAdapter ) : ViewModel() {

    private var arraylis: List<Currency.Datum> =adaper.GetCurrencyList()
    private var adapter: CurrancyAdapter = adaper
    private var recycleview:RecyclerView = recycleview

    public fun Search(word: String) {
        var chosen: ArrayList<Currency.Datum> = arrayListOf()

        var word2 = word.toLowerCase()

        for (currency: Currency.Datum in arraylis) {
            var temp = currency.name!!.toLowerCase()
            if (temp!!.contains(word2))
                chosen.add(currency)
        }

        UpdateList(chosen)

    }

    public fun UpdateList(currencylist: ArrayList<Currency.Datum>) {

        if(currencylist.size==0)
            recycleview.setVisibility(View.GONE)
        else{
            recycleview.setVisibility(View.VISIBLE)
            adapter.SetCurrency(currencylist)
            adapter.notifyDataSetChanged()
        }


    }


}