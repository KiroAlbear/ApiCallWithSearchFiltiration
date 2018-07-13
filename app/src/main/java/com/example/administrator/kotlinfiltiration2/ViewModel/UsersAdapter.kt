package com.example.administrator.kotlinfiltiration2.ViewModel

import android.graphics.Color
import android.graphics.ColorSpace
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.administrator.kotlinfiltiration2.Model.User
import com.example.administrator.kotlinfiltiration2.R
import javax.security.auth.callback.Callback

class UsersAdapter(userlist:ArrayList<User>) : RecyclerView.Adapter<UsersAdapter.Holder>()  {
    var usersList: ArrayList<User> = userlist
    var colorlist:ArrayList<Int> = arrayListOf()
    var col =0
    var greencolor=0



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.item,p0,false)
        return Holder(v)
    }

    override fun getItemCount(): Int {
        return usersList.size

    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {

        p0.textview.setText(usersList.get(p1).name)

SetColor(p0)

    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textview: TextView = itemView.findViewById(R.id.itemtext) as TextView
    }

    private fun SetColor(p0: Holder){


        if(col==0){
             greencolor=100
             col =  Color.rgb(45,greencolor,255)
        }
        else
        {
            if(greencolor>230)
                greencolor=100

            greencolor+=15
            col =  Color.rgb(45,greencolor,255)
        }



        p0.textview.setBackgroundColor(col)
    }

     public fun RemoveItem(position:Int){
         usersList.removeAt(position)
         notifyDataSetChanged()
     }

    public fun RemoveView(viewholder:RecyclerView.ViewHolder)
    {
        (viewholder.itemView.parent as ViewGroup).removeView(viewholder.itemView)
        notifyDataSetChanged()
    }

}
