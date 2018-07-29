package com.example.administrator.kotlinfiltiration2.ViewModel

import android.arch.persistence.room.Room
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.administrator.kotlinfiltiration2.Model.Currency
import com.example.administrator.kotlinfiltiration2.Model.currencyDataBase
import com.example.administrator.kotlinfiltiration2.R
import com.example.administrator.kotlinfiltiration2.databinding.ItemBinding
import com.example.administrator.kotlinfiltiration2.R.layout.item



class CurrancyAdapter(currencylist: List<Currency.Companion.Datum>) : RecyclerView.Adapter<CurrancyAdapter.Holder>() {
    //  var usersList: ArrayList<User> = userlist
    private var colorlist: ArrayList<Int> = arrayListOf()
    var col = 0
    var greencolor = 0
    var currency: List<Currency.Companion.Datum> = currencylist





    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {

    //    val view = LayoutInflater.from(p0.getContext()).inflate(R.layout.item, p0, false)
        val inflater = LayoutInflater.from(p0.context)
        val binding = ItemBinding.inflate(inflater)

        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return currency.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {

        p0.bind(currency[p1])

        SetColor(p0)

    }


    class Holder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Currency.Companion.Datum) {
            with(binding) {
                CurencyName.text = item.name
                Symbol.text = item.symbol
                // websiteSlug.text =item.websiteSlug
                websitename.text = item.websiteSlug

            }

        }
        //val textview: TextView = itemView.findViewById(R.id.itemtext) as TextView

    }

    private fun SetColor(p0: Holder) {


        if (col == 0) {
            greencolor = 100
            col = Color.rgb(45, greencolor, 255)
        } else {
            if (greencolor > 230)
                greencolor = 100

            greencolor += 15
            col = Color.rgb(45, greencolor, 255)
        }



        p0.itemView.setBackgroundColor(col)
    }

    public fun RemoveItem(position: Int) {
        //  currency.removeAt(position)
        notifyDataSetChanged()
    }

    public fun RemoveView(viewholder: RecyclerView.ViewHolder) {
        (viewholder.itemView.parent as ViewGroup).removeView(viewholder.itemView)
        notifyDataSetChanged()
    }

    fun GetCurrencyList(): List<Currency.Companion.Datum> {
        return this.currency
    }

    fun SetCurrency(currencyt: List<Currency.Companion.Datum>) {
        this.currency = currencyt

    }


}
