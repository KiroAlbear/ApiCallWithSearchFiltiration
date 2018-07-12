package com.example.administrator.kotlinfiltiration2.ViewModel

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.administrator.kotlinfiltiration2.Model.User
import com.example.administrator.kotlinfiltiration2.R

class UsersAdapter(userlist:ArrayList<User>,colorlis:ArrayList<String>) : RecyclerView.Adapter<UsersAdapter.Holder>() {
    var usersList: ArrayList<User> = userlist
    var colorlist:ArrayList<String> = colorlis

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.item,p0,false)
        return Holder(v)
    }

    override fun getItemCount(): Int {
        return usersList.size

    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {

        p0.textview.setText(usersList.get(p1).name)
        p0.textview.setBackgroundColor(Color.parseColor(colorlist[p1]))
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textview: TextView = itemView.findViewById(R.id.itemtext) as TextView
    }



}
