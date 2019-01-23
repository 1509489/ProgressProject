package com.example.progressproject.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.progressproject.data.models.ApiResponse
import com.example.progressproject.data.models.Response
import com.example.progressproject.data.repository.Repository
import com.example.progressproject.network.NetworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryImpl(private val networkService: NetworkService) : Repository {
    private val response = MutableLiveData<Response>()

    override fun getArticle(
        query: String,
        apiKey: String
    ): LiveData<Response> {
        networkService.getSearch(query).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { t1: ApiResponse, error: Throwable ->
                response.value = t1.response
                error.printStackTrace()
            }
        return response
    }
}