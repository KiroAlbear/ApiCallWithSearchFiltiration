package com.example.administrator.kotlinfiltiration2.Model

import android.os.Build
import android.support.annotation.RequiresApi

class UsersList
{
    private var userslist:ArrayList<User> = arrayListOf()
    public fun AddingUsers():ArrayList<User> {


        userslist.add(User("Ahmed",123,"DownTown"))
        userslist.add(User("Ahmed",123,"DownTown"))
        userslist.add(User("Mostafa",123,"DownTown"))
        userslist.add(User("Abdullah",123,"DownTown"))
        userslist.add(User("Sara",123,"DownTown"))
        userslist.add(User("David",123,"DownTown"))
        userslist.add(User("Ayman",123,"DownTown"))
        return userslist
    }

    public fun ColorList():ArrayList<String>{
        val colorlist=ArrayList<String> ()
        colorlist.add("#4274f4")
        colorlist.add("#4195f4")
        colorlist.add("#41a0f4")
        colorlist.add("#41b5f4")
        colorlist.add("#41c1f4")
        colorlist.add("#41cdf4")
        colorlist.add("#41d6f4")

        return colorlist



    }
}