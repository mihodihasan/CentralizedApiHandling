package com.mihodihasan.centralizedapihandling.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BaseApiResponseModel {
    @SerializedName("success")
    @Expose
    var success: Boolean = false

    @SerializedName("msg")
    @Expose
    var msg: String = ""

    @SerializedName("code")
    @Expose
    var code: Int = 0
}