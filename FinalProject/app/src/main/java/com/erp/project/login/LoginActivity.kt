package com.erp.project.login

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.erp.project.R
import com.erp.project.mainpage.MainActivity
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var autoLogin: CheckBox
    private lateinit var fingerprintLogin: CheckBox
    private lateinit var enter_id: EditText
    private lateinit var enter_pw: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        autoLogin = findViewById(R.id.login_cb_autologin)
        enter_id = findViewById(R.id.login_pt_id)
        enter_pw = findViewById(R.id.login_pw_password)
        autoLogin()

    }

    /*로그인 클릭 시 로그인 처리에 대한 메소드*/
    fun loginConnect(v: View) {
        val tomcatMassage: String
        val id = enter_id.text.toString()
        val pw = enter_pw.text.toString()
        try {
            val loginTomcat = LoginConnectTomcat()
            if (id.isNotEmpty() && pw.isNotEmpty()) {
                tomcatMassage = loginTomcat.execute(id, pw).get()
                if (tomcatMassage != null) {
                    val nextMainPage = Intent(this, MainActivity::class.java)
                    startActivity(nextMainPage)
                }
            } else {
                Toast.makeText(applicationContext, "아이디와 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Log.i("LoginActivity", e.toString())
        }
    }


    /*자동 로그인 메소드*/
    private fun autoLogin() {
        sharedPreferences = getSharedPreferences("auto", 0)
        editor = sharedPreferences.edit()
        autoLogin.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                val input_id = enter_id.text.toString()
                val input_pw = enter_pw.text.toString()
                editor.putString("input_id", input_id)
                editor.putString("input_pw", input_pw)
                editor.putBoolean("autoLoginEnabled", true)
                editor.apply()
            } else {
                editor.remove("input_id")
                editor.remove("input_pw")
                editor.remove("autoLoginEnabled")
                editor.clear()
                editor.apply()
            }
        }
        if (sharedPreferences.getBoolean("autoLoginEnabled",false)){
            enter_id.setText(sharedPreferences.getString("input_id","").toString())
            enter_pw.setText(sharedPreferences.getString("input_pw","").toString())
            autoLogin.isChecked = true
        }
    }

    fun passwordPopup(view: View) {
        val customDialog = LayoutInflater.from(this).inflate(R.layout.login_custom_popup, null, false)
        val builder = AlertDialog.Builder(this)
            .setView(customDialog)
        val alertDialog : AlertDialog = builder.create();
        alertDialog.setCancelable(false)
        alertDialog.show()
        val closeButton = customDialog.findViewById<Button>(R.id.login_custom_button)
        closeButton.setOnClickListener{
            alertDialog.dismiss()
        }
    }


/*    else if(autoLogin.isChecked && sharedPreferences.getBoolean("autoLoginEnabled",true)){
        tomcatMassage = loginTomcat.execute(id,pw).get()
        if(tomcatMassage != null){
            val nextMainPage = Intent(this, MainActivity::class.java)
            startActivity(nextMainPage)
            finish()
        }
    }*/

}

