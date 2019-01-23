package com.example.progressproject.data.models

import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("docs")val docs:List<Doc>,
                    @SerializedName("meta")val meta: Meta)