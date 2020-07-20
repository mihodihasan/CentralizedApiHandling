package com.mihodihasan.centralizedapihandling.utils

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.mihodihasan.centralizedapihandling.R

class Utils {

    companion object {
        var dialog: AlertDialog? = null
        fun dismissLoadingDialog() {
            if (dialog != null && dialog!!.isShowing) dialog!!.dismiss()
        }

        fun showLoadingDialog(context: Context?) {
            dismissLoadingDialog()

            val builder: AlertDialog.Builder =
                AlertDialog.Builder(
                    context!!
                )

            dialog = builder
                .setView(LayoutInflater.from(context).inflate(R.layout.loading_layout, null))
                .setCancelable(false)
                .create()
            dialog!!.show()

        }

        fun showPopup(
            context: Context?,
            title: String?,
            msg: String?
        ) {
            val builder: AlertDialog.Builder =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    AlertDialog.Builder(
                        context!!,
                        R.style.Theme_AppCompat_Light_Dialog_Alert
                    )
                } else {
                    AlertDialog.Builder(context!!)
                }
            val dialog: Dialog = builder
                .setTitle(title)
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("Dismiss") { d, _ -> d.dismiss() }
                .create()
            dialog.show()
        }
    }
}