package com.mihodihasan.centralizedapihandling.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {
        private var okHttpClient: OkHttpClient? = null
            get() {
                if (field == null) field = OkHttpClient().newBuilder()
                    .connectTimeout(40, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build()
                return field
            }
        private const val BASE_URL: String = "https://error-centralized-response.herokuapp.com/"
        private var retrofit: Retrofit? = null

        fun getClient(): ApiService {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(okHttpClient!!)
                    .build()
            }
            return retrofit!!.create<ApiService>(ApiService::class.java)
        }

    }
}
