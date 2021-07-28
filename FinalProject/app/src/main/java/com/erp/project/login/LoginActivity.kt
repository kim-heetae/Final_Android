package com.erp.project.login

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.KeyEvent.ACTION_DOWN
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.erp.project.R
import com.erp.project.common.DataCoroutine
import com.erp.project.mainpage.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.json.JSONArray
import org.json.JSONObject

class LoginActivity : LoadingActivity() {
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
        enterKeyController()
        autoLogin()

    }

    /*로그인 클릭 시 로그인 처리에 대한 메소드*/
    fun loginConnect(v: View) {
        val tomcatMessage: String
        val id = enter_id.text.toString()
        val pw = enter_pw.text.toString()
        val ad = "ad"
        try {
            val loginTomcat = LoginConnectTomcat()
            if (id.isNotEmpty() && pw.isNotEmpty()) {
                tomcatMessage = loginTomcat.execute(id, pw, ad).get()
                Log.i("loginConnect", "TEST값 ======> $tomcatMessage")
                val jarray: JSONArray = JSONArray(tomcatMessage)
                Log.i("IDTest", "ID값 ==> $jarray")
                //[]에서 각각의 값을 {}(object)로 담아줌.
                val jsonObject: JSONObject = jarray.getJSONObject(0)
                val jsonEno: String = jsonObject.getString("E_NO")
                val jsonAuth: String = jsonObject.getString("PA_AUTH")
                val jsonEpos: String = jsonObject.getString("E_POS")
                val jsonEname: String = jsonObject.getString("E_NAME")
                val jsonDno: String = jsonObject.getString("D_NO")
                val jsonDname: String = jsonObject.getString("D_NAME")
                if (jsonEno == id) {
                    val nextMainPage = Intent(this, MainActivity::class.java)
                    val putData: DataConstructor = DataConstructor(jsonAuth, jsonEpos, jsonEname, jsonEno, jsonDno,jsonDname)//직렬화로 데이터값 저장
                    nextMainPage.putExtra("Data", putData)
                    startActivity(nextMainPage)
                } else {
                    Toast.makeText(applicationContext, "아이디와 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT)
                        .show()
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
        if (sharedPreferences.getBoolean("autoLoginEnabled", false)) {
            enter_id.setText(sharedPreferences.getString("input_id", "").toString())
            enter_pw.setText(sharedPreferences.getString("input_pw", "").toString())
            autoLogin.isChecked = true
        }
    }

    /*forget password 클릭 시 팝업창*/
    fun passwordPopup(view: View) {
        val customDialog =
            LayoutInflater.from(this).inflate(R.layout.login_custom_popup, null, false)
        val builder = AlertDialog.Builder(this)
            .setView(customDialog)
        val alertDialog: AlertDialog = builder.create();
        alertDialog.setCancelable(false)
        alertDialog.show()
        val closeButton = customDialog.findViewById<Button>(R.id.login_custom_button)
        closeButton.setOnClickListener {
            alertDialog.dismiss()
        }
    }

// 지문로그인 연결 시 사용
/*    else if(autoLogin.isChecked && sharedPreferences.getBoolean("autoLoginEnabled",true)){
        tomcatMassage = loginTomcat.execute(id,pw).get()
        if(tomcatMassage != null){
            val nextMainPage = Intent(this, MainActivity::class.java)
            startActivity(nextMainPage)
            finish()
        }
    }*/

    private fun enterKeyController() {
        val idArea = findViewById<EditText>(R.id.login_pt_id)
        val pwArea = findViewById<EditText>(R.id.login_pw_password)
        idArea.setOnEditorActionListener { v, id, event ->
            if (id == EditorInfo.IME_ACTION_NEXT) {
                pwArea.requestFocus()
            }
            true
        }
        pwArea.setOnKeyListener { v, keyCode, event ->
            if ((event.action == ACTION_DOWN) && (keyCode == KEYCODE_ENTER)) {
                val imm: InputMethodManager =
                    getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(pwArea.windowToken, 0)
            }
            false
        }

    }

    private fun startProgress() {
        progressON("Loading...")
        Handler().postDelayed({ progressOFF() }, 3500)
    }

}

