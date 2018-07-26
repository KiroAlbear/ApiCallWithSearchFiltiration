package com.example.administrator.kotlinfiltiration2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.example.administrator.kotlinfiltiration2.Model.Currency
import com.example.administrator.kotlinfiltiration2.ViewModel.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.math.log

import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {


    // private var userlist: ArrayList<User> = arrayListOf()
   // private var uList: UsersList = UsersList()

    lateinit var currencyAdapter: CurrancyAdapter
    private lateinit var search:SearchCurrency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.coinmarketcap.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val request = retrofit.create(CurrencyApi::class.java)

//      val a=  api.getcurrency().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                       var response:CurrencyApiResponse=it
////                        //CurrencyAdapter.SetCurrency(it.data)
//                    CurrencyAdapter = UsersAdapter(response.data)
//                    Toast.makeText(applicationContext,response.data.ID().name.toString(),Toast.LENGTH_LONG).show()
//
//                },{
//                  Toast.makeText(applicationContext,it.message,Toast.LENGTH_LONG).show()
//                })



        var call: Call<Currency> = request.getcurrency()

        call.enqueue(object : Callback<Currency> {
            override fun onFailure(call: Call<Currency>?, t: Throwable?) {

                Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Currency>?, response: Response<Currency>?) {

                var currencyresponse: List<Currency.Datum> = response!!.body()!!.data!!

               // var currencies = currencyresponse!!.data.
                currencyAdapter = CurrancyAdapter(currencyresponse)
                myRecycleView.layoutManager = GridLayoutManager(applicationContext, 1)
                myRecycleView.adapter = currencyAdapter

                search=SearchCurrency(applicationContext,myRecycleView,currencyAdapter)

                Toast.makeText(applicationContext, currencyresponse!![2].name,Toast.LENGTH_SHORT).show()


            }
        })


//        call.enqueue(object : Callback<List<CurrencyApiResponse>>{
//            override fun onFailure(call: Call<List<CurrencyApiResponse>>?, t: Throwable?) {
//                Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_LONG).show()
//                Log.w("",t.toString())
//            }
//
//            override fun onResponse(call: Call<List<CurrencyApiResponse>>?, response: Response<List<CurrencyApiResponse>>?) {
//                Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
//                Log.w("","Success")
//            }
//        })




        //    var search  = SearchUsers(this,myRecycleView,CurrencyAdapter)


//        val recycleview = findViewById<RecyclerView>(R.id.myRecycleView)

        //search=SearchUsers(this,recyclerView,usersadapter)

        // activityMainBinding.search = SearchUsers(this,myRecycleView,usersadapter,userlist)

            myeditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                 search.Search(p0.toString())
            }
        })

        //var swipaction = SwipAction(myRecycleView,CurrencyAdapter)
        //swipaction.SetSwipAction()


    }
}

