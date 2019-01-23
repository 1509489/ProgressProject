package com.example.progressproject.data.models

import com.google.gson.annotations.SerializedName

data class Headline(@SerializedName("main")val main:String,
                    @SerializedName("kicker")val kicker:Any,
                    @SerializedName("content_kicker")val contentKicker:Object,
                    @SerializedName("print_headline")val printHeadline:String,
                    @SerializedName("name")val name:Any,
                    @SerializedName("seo")val seo:Any,
                    @SerializedName("sub")val sub:Any)