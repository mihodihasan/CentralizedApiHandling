package com.mihodihasan.centralizedapihandling.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ExampleApiResponseModel : BaseApiResponseModel() {
    @SerializedName("data")
    @Expose
    val data : DataExampleApiResponse? = null
}