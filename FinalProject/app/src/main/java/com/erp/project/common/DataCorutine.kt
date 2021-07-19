package com.erp.project.common

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject

//okhttp로 변환 -> inputstream outputstream 없어도 적용 가능.
//okhttp 더 위에 있는 것 => retrofit
//Unit(void)가 아닌 String으로 받아야 하는데...

class DataCoroutine(val id: String, val pw: String, val ad: String) {
    lateinit var putData: String
    fun loginConnect(): String {
        putData = Job.toString()
        val http = CoroutineScope(IO).launch {
            val connect = CoroutineScope(Default).async {
                getHttp(id, pw, ad)
            }
            if (getHttp(id, pw, ad) != null) {
                connect.await()
            } else {
                connect.cancel()
            }
            Log.i("Connect", "==================>$connect" )
        }
        Log.i("http", "=================$http")
        putData = http.isActive.toString()
        return putData
    }

    fun getHttp(id: String, pw: String, ad: String): String? {
        var data: String? = null
        //클라이언트 만들기
        val client = OkHttpClient.Builder().build()
        //요청하기
        val req_body: FormBody = FormBody.Builder()
            .add("e_no", id)
            .add("e_pw", pw)
            .add("ad", ad)
            .build()

        val req = Request.Builder()
            .url("http://192.168.0.64:9000/getLoginForm2.lg")
            .post(req_body)
            .build()
        //응답
        client.newCall(req).execute().use { response ->
            if (response.body != null) {
                val jarray: JSONArray = JSONArray(response.body!!.string())
                Log.i("IDTest", "ID값 ==> $jarray")
                //[]에서 각각의 값을 {}(object)로 담아줌.
                val jsonObject: JSONObject = jarray.getJSONObject(0)
                val jsonEno: String = jsonObject.getString("E_NO")
                Log.i("LoginActivity", "ID값 ==> $jsonEno")
                when (jsonEno) {
                    id -> {
                        data = response.body.toString()
                        Log.i("data", "================$data")
                    }
                    else -> return null
                }
            } else {
                "Not Data"
            }
        }
        return data
    }
}


