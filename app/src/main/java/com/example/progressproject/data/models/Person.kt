package com.example.progressproject.data.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Person(@SerializedName("firstname")val firstname:String,
                  @SerializedName("middlename")val middlename:Any,
                  @SerializedName("lastname")val lastname:String,
                  @SerializedName("qualifier")val qualifier:Any,
                  @SerializedName("title")val title: Any,
                  @SerializedName("role")val role:String,
                  @SerializedName("organization")val organization:String,
                  @SerializedName("rank")val rank:Int)