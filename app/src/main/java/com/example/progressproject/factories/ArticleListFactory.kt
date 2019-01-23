package com.example.progressproject.factories

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.progressproject.data.repository.RepositoryImpl
import com.example.progressproject.ui.home.ArticleListViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ArticleListFactory /*@Inject constructor*/(private val repositoryImpl: RepositoryImpl): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ArticleListViewModel::class.java)) ArticleListViewModel(repositoryImpl) as T
        else throw IllegalArgumentException("ViewModel Not Found")
    }

}