package com.mihodihasan.centralizedapihandling.network

import com.mihodihasan.centralizedapihandling.model.ExampleApiResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("example")
    fun getExampleString(): Call<ExampleApiResponseModel?>
}