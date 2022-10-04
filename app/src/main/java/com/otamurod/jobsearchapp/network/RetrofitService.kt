package com.otamurod.apicallusingmvvmcoroutines.network

import com.otamurod.jobsearchapp.model.ListItemModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET(value = "companies")
    suspend fun getDataFromAPI(@Query("q") query: String): ListItemModel
}