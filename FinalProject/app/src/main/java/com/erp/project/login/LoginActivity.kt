package com.erp.project.login

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.erp.project.R
import java.util.prefs.AbstractPreferences

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var autoLogin : CheckBox
    private lateinit var fingerprintLogin : CheckBox
    private lateinit var enter_id : EditText
    private lateinit var enter_pw : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        autoLogin = findViewById(R.id.login_cb_autologin)
        enter_id = findViewById(R.id.login_pt_id)
        enter_pw = findViewById(R.id.login_pw_password)
        autoLogin()
    }

    fun loginConnect(){

    }

    /*자동 로그인 메소드*/
    private fun autoLogin(){
        sharedPreferences = getSharedPreferences("auto", Activity.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        autoLogin.setOnCheckedChangeListener { buttonView, isChecked ->
            if (autoLogin.isChecked) {
                val input_id = enter_id.text.toString()
                val input_pw = enter_pw.text.toString()
                editor.putString("input_id", input_id)
                editor.putString("input_pw", input_pw)
                editor.putBoolean("autoLoginEnabled", true)
            } else {
                editor.remove("input_id")
                editor.remove("input_pw")
                editor.remove("autoLoginEnabled")
                editor.clear()
            }
            editor.apply()
        }
    }

    fun passwordPopup(){

    }

}

