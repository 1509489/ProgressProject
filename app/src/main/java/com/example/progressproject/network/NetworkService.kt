package com.example.progressproject.network

import com.example.progressproject.common.RELATIVE_URL
import com.example.progressproject.data.models.ApiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/***
 * You forgot to add the api-key query field
 */
interface NetworkService {
    @GET(RELATIVE_URL)
    fun getSearch(
        @Query("q") search: String,
        @Query("api-key") apiKey: String
    ): Single<ApiResponse>
}