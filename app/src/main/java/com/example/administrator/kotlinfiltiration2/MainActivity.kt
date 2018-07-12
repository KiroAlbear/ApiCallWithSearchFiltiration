package com.example.administrator.kotlinfiltiration2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import com.example.administrator.kotlinfiltiration2.Model.User
import com.example.administrator.kotlinfiltiration2.Model.UsersList
import com.example.administrator.kotlinfiltiration2.ViewModel.SearchUsers
import com.example.administrator.kotlinfiltiration2.ViewModel.UsersAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    private  var userlist:ArrayList<User> = arrayListOf()
    private  var uList: UsersList = UsersList()
    private lateinit var usersadapter:UsersAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

          setContentView(R.layout.activity_main)

          userlist =uList.AddingUsers()


        usersadapter = UsersAdapter(userlist,uList.ColorList())
        var search  = SearchUsers(this,myRecycleView,usersadapter,userlist)

        //usersadapter = UsersAdapter(userlist)
        val recycleview = findViewById<RecyclerView>(R.id.myRecycleView)

        //search=SearchUsers(this,recyclerView,usersadapter)
        recycleview.layoutManager =  LinearLayoutManager(this@MainActivity)
        myRecycleView.adapter = usersadapter
      //  activityMainBinding.search = SearchUsers(this,myRecycleView,usersadapter,userlist)

           myeditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                search.Search(p0.toString())
            }
        })







    }
}
