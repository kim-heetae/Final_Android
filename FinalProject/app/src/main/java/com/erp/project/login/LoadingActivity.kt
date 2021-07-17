package com.erp.project.login

import androidx.appcompat.app.AppCompatActivity

open class LoadingActivity : AppCompatActivity() {
    fun progressON() {
        LoginApplication.getInstance()?.progressON(this, null)
    }

    fun progressON(message: String?) {
        if (message != null) {
            LoginApplication.getInstance()?.progressON(this, message)
        }
    }

    fun progressOFF() {
        LoginApplication.getInstance()?.progressOFF()
    }

}