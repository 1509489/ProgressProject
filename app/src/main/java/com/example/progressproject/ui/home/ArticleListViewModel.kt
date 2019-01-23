package com.example.progressproject.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.progressproject.common.API_KEY
import com.example.progressproject.data.models.Response
import com.example.progressproject.data.repository.RepositoryImpl
import javax.inject.Inject

class ArticleListViewModel @Inject constructor(private val repositoryImpl: RepositoryImpl) : ViewModel() {

    fun getSearch(query: String): LiveData<Response> =
        repositoryImpl.getArticle(query, API_KEY)
}