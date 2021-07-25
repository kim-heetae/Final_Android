package com.erp.project.login

import android.app.Activity
import android.app.Application
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog
import com.erp.project.R


class LoginApplication : Application() {

   lateinit var progressDialog: AppCompatDialog

    companion object{
        private var loginApplication: LoginApplication? = null
        fun getInstance() : LoginApplication? {
            return loginApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        loginApplication = this
    }

    fun progressON(activity: Activity, message: String?) {

        if(activity.isFinishing){return}

        if (progressDialog.isShowing) {
            if (message != null) {
                progressSET(message)
            }
        } else {
            progressDialog = AppCompatDialog(this)
            progressDialog.setCancelable(false)
            progressDialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
            progressDialog.setContentView(R.layout.loading_dialog)
            progressDialog.show()
        }
        val loading_frame = progressDialog.findViewById<ImageView>(R.id.loading_image)
        val frameAnimation = loading_frame?.background as AnimationDrawable
        loading_frame.post(Runnable { frameAnimation.start() })

        val loading_message = progressDialog.findViewById<TextView>(R.id.loading_message)
        if (!TextUtils.isEmpty(message)) {
            loading_message?.text = message
        }

    }

    private fun progressSET(message: String) {
        if (!progressDialog.isShowing) {
            return
        }
        val loading_message = progressDialog.findViewById<TextView>(R.id.loading_message)
        if (!TextUtils.isEmpty(message)) {
            loading_message?.text = message
        }
    }

    fun progressOFF() {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }
}



