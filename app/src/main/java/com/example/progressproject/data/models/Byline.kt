package com.example.progressproject.data.models
import com.google.gson.annotations.SerializedName

data class Byline(@SerializedName("original") val original:String,
                  @SerializedName("person")val person:List<Person>,
                  @SerializedName("organization")val organization:String)