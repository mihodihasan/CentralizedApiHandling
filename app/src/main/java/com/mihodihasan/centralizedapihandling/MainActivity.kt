package com.mihodihasan.centralizedapihandling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mihodihasan.centralizedapihandling.model.ExampleApiResponseModel
import com.mihodihasan.centralizedapihandling.network.ApiClient
import com.mihodihasan.centralizedapihandling.network.CentralApiCallBack
import com.mihodihasan.centralizedapihandling.utils.Utils
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiClient.getClient().getExampleString().enqueue(object :CentralApiCallBack<ExampleApiResponseModel?>(this){
            override fun handleResponse(
                call: Call<ExampleApiResponseModel?>?,
                response: Response<ExampleApiResponseModel?>?
            ) {
                Utils.showPopup(this@MainActivity, getString(R.string.success), response?.body()?.data?.yourCustomData)
            }
        })
    }
}
