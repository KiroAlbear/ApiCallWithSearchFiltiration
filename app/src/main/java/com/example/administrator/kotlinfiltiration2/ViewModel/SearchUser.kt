package com.example.administrator.kotlinfiltiration2.ViewModel

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.administrator.kotlinfiltiration2.Model.User

class SearchUsers(context: Context, recycleview: RecyclerView, adaper: UsersAdapter, userslist: ArrayList<User>) : ViewModel() {
    private var arraylis: ArrayList<User> =userslist
    private var adapter: UsersAdapter = adaper
    private var recycleview:RecyclerView = recycleview

    public fun Search(word: String) {
        var chosen: ArrayList<User> = arrayListOf()

        var word2 = word.toLowerCase()

        for (user: User in arraylis) {
            var temp = user.name.toLowerCase()
            if (temp.contains(word2))
                chosen.add(user)
        }

        UpdateList(chosen)

    }

    public fun UpdateList(chosenlist: ArrayList<User>) {

        if(chosenlist.size==0)
            recycleview.setVisibility(View.GONE)
        else{
            recycleview.setVisibility(View.VISIBLE)
            adapter.usersList = chosenlist
            adapter.notifyDataSetChanged()
        }


    }




}