package com.erp.project.login

import android.os.AsyncTask
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL


class LoginConnectTomcat : AsyncTask<String, Void, String>() {
    //앱에서 입력한 아이디와 비번을 담아서 톰캣 서버에 전달
    var sendMsg: String? = null
    //톰캣서버를 통해서 처리된 결과를 받아서 담기
    var receiveMsg: String? = null
    //반드시 재정의해야 할 메소드이다.
    //백그라운드에서 실행할 코드를 포함하는 메소드임.
    override fun doInBackground(vararg strings: String): String? {
        //String apiURL = "http://192.168.0.244:7000/android/androidOracleConnection.jsp";
        val apiURL = "http://192.168.0.56:9000/getLoginForm.lg"
        try {
            val url = URL(apiURL)
            val con = url.openConnection() as HttpURLConnection
            con.setRequestProperty("Connection-Type", "application/x-www-form-urlencoded")
            con.requestMethod = "POST"
            Log.i("LoginConnectTomcat", "con:$con")
            val osw = OutputStreamWriter(con.outputStream)
            //톰캣 서버에 전송할 메시지 처리
            sendMsg = "e_no=" + strings[0] + "&e_pw=" + strings[1]
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
        } catch (e: Exception) {
            Log.i("LoginConnectTomcat", "Exception:$e")
        }
        return receiveMsg
    }


}