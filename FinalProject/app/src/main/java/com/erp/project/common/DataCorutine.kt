package com.erp.project.common

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class DataCorutine {
    var sendMsg: String? = null
    var receiveMsg: String? = null
    fun loginConnect(id: String, pw: String, ad: String) {
        CoroutineScope(IO).launch {
            val apiURL = "http://192.168.1.10:9000/getLoginForm2.lg"//여기는 자신의 ip주소 및 port번호로 맞추기 --> 톰캣서버 접속용 그 후에 자바로 이동
            val url = URL(apiURL)
            val con = url.openConnection() as HttpURLConnection
            con.setRequestProperty("Connection-Type", "application/x-www-form-urlencoded")
            con.requestMethod = "POST"
            Log.i("LoginConnectTomcat", "con:$con")
            val osw = OutputStreamWriter(con.outputStream)
            //톰캣 서버에 전송할 메시지 처리
            sendMsg = "e_no=$id&e_pw=$pw&ad=$ad"
            Log.i("LoginConnectTomcat", sendMsg!!)
            osw.write(sendMsg)
            osw.flush()
            val responseCode = con.responseCode //200 204 404 500]
            Log.i("LoginConnectTomcat", "responseCode:$responseCode")
            var br: BufferedReader? = null
            if (responseCode == HttpURLConnection.HTTP_OK) {
                br = BufferedReader(
                    InputStreamReader(
                        con.inputStream, "UTF-8"))
                var inputLine: String? = null
                val sb_res = StringBuilder()
                while (br.readLine().also { inputLine = it } != null) {
                    sb_res.append(inputLine)
                }
                receiveMsg = sb_res.toString()
                Log.i("LoginConnectTomcat", "receiveMsg:$receiveMsg")
            }
        }
        return
    }
}

