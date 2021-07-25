package com.erp.project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erp.project.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val nextLogin = Intent(this, LoginActivity::class.java)

        try{
            Thread.sleep(3000)
        }
        catch(e:Exception){

        }
        startActivity(nextLogin)
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}