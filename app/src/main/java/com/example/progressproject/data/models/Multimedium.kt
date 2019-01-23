package com.example.progressproject.data.models

import com.google.gson.annotations.SerializedName

data class Multimedium(@SerializedName("rank")val rank:Int,
                       @SerializedName("subtype")val subtype:String,
                       @SerializedName("caption")val caption:Any,
                       @SerializedName("credit")val credit:Any,
                       @SerializedName("type")val type:String,
                       @SerializedName("url")val url:String,
                       @SerializedName("height")val height:Int,
                       @SerializedName("width")val  width:Int,
                       @SerializedName("legacy")val legacy: Legacy,
                       @SerializedName("subType")val  subType:String,
                       @SerializedName("crop_name") val cropName:String)