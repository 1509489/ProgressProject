package com.example.progressproject.data.models

import com.google.gson.annotations.SerializedName

data class Keyword(@SerializedName("name")val name:String,
                   @SerializedName("value")val value:String,
                   @SerializedName("rank")val rank:Int,
                   @SerializedName("major")val major:String)