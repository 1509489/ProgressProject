package com.example.progressproject.data.models
import com.google.gson.annotations.SerializedName

data class Doc(@SerializedName("web_url")val webUrl:String,
               @SerializedName("snippet")val snippet:String,
               @SerializedName("blog")val blog: Blog,
               @SerializedName("multimedia")val multimedia:List<Multimedium>,
               @SerializedName("headline")val headline:Headline,
               @SerializedName("keywords")val keywords:List<Keyword>,
               @SerializedName("document_type")val documentType:String,
               @SerializedName("section_name")val sectionName:String,
               @SerializedName("type_of_material")val typeOfMaterial:String,
               @SerializedName("_id")val id:String,
               @SerializedName("word_count")val wordCount:Int,
               @SerializedName("score")val score:Double,
               @SerializedName("print_page")val printPage:String,
               @SerializedName("source")val source:String,
               @SerializedName("pub_date")val pubDate:String,
               @SerializedName("news_Desk")val newsDesk:String,
               @SerializedName("byline")val byline: Byline,
               @SerializedName("uri")val uri:String)