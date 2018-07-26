package com.example.administrator.kotlinfiltiration2.ViewModel

import android.media.MediaRouter
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import javax.security.auth.callback.Callback

class SwipAction(recyclerview: RecyclerView, adapter: CurrancyAdapter) {
    var adapter = adapter
    val recyclerview = recyclerview
    fun SetSwipAction() {
        val itemtouch = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
                return true
            }

            override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
                val position = p0.adapterPosition
                if (p1 == ItemTouchHelper.LEFT||p1 == ItemTouchHelper.RIGHT) {
                    adapter.RemoveItem(position)
                    adapter.RemoveView(p0)

                }
                else {

                }
            }
        }

        val setswip = ItemTouchHelper(itemtouch)
        setswip.attachToRecyclerView(recyclerview)

    }
}