package com.example.administrator.kotlinfiltiration2.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Currency {

    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

    companion object {
        @Entity(tableName = "currencytable")
         class Datum {
            @PrimaryKey
            @SerializedName("id")
            @Expose
            var id: Int? = null


            @ColumnInfo(name = "name")
            @SerializedName("name")
            @Expose
            var name: String? = null


            @ColumnInfo(name="symbol")
            @SerializedName("symbol")
            @Expose
            var symbol: String? = null


            @ColumnInfo(name="website_slug")
            @SerializedName("website_slug")
            @Expose
            var websiteSlug: String? = null
        }

    }

}



