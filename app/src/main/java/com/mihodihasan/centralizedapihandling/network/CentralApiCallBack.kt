package com.mihodihasan.centralizedapihandling.network

import android.content.Context
import com.mihodihasan.centralizedapihandling.R
import com.mihodihasan.centralizedapihandling.model.BaseApiResponseModel
import com.mihodihasan.centralizedapihandling.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class CentralApiCallBack<T : BaseApiResponseModel?>(private val context: Context) :
    Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {
        Utils.dismissLoadingDialog()
        if (response.code() == 200) {
            if (response.body()!!.success) {
                handleResponse(call, response)
            } else {
                //You might need to handle some auth token refresh api call inside here observing `response.body().code`
            }
        } else {
            handleError(context.getString(R.string.please_try_again_))
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        Utils.dismissLoadingDialog()
        handleError(t.message)
    }

    abstract fun handleResponse(
        call: Call<T>?,
        response: Response<T>?
    )

    private fun handleError(errorString: String?) {
        Utils.showPopup(context, context.getString(R.string.error), errorString)
    }

    init {
        Utils.showLoadingDialog(context)
    }
}
