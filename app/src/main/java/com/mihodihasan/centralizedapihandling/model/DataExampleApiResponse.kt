package com.mihodihasan.centralizedapihandling.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataExampleApiResponse {
    @SerializedName("your_custom_data")
    @Expose
    val yourCustomData: String = ""
}