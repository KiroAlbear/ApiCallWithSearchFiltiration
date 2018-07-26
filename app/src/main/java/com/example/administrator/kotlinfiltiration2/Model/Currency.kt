package com.example.administrator.kotlinfiltiration2.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Currency {

    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null


    inner class Datum {

        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("name")
        @Expose
        var name: String? = null
        @SerializedName("symbol")
        @Expose
        var symbol: String? = null
        @SerializedName("website_slug")
        @Expose
        var websiteSlug: String? = null
    }

}



