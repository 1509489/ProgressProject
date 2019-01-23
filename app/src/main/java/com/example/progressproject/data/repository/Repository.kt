package com.example.progressproject.data.repository

import android.arch.lifecycle.LiveData
import com.example.progressproject.data.models.Response

interface Repository {
    fun getArticle(query: String, apiKey: String): LiveData<Response>
}