package com.example.progressproject.data.models

import com.google.gson.annotations.SerializedName

data class Legacy(@SerializedName("xlarge")val xlarge:String,
                  @SerializedName("xlargewidth")val xlargewidth:Int,
                  @SerializedName("xlargeheight")val xlargeheight:Int,
                  @SerializedName("wide")val wide:String,
                  @SerializedName("widewidth")val widewidth:Int,
                  @SerializedName("wideheight")val wideheight:Int,
                  @SerializedName("thumbnail")val thumbnail:String,
                  @SerializedName("thumbnailwidth")val thumbnailwidth:Int,
                  @SerializedName("thumbnailheight")val thumbnailheight:Int)