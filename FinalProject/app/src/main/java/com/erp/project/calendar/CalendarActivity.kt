package com.erp.project.calendar

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.erp.project.R
import com.erp.project.login.DataConstructor

class CalendarActivity : AppCompatActivity() {
    val data : DataConstructor? = intent.getParcelableExtra("data")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val eno : TextView = findViewById(R.id.tv_id)
        val ename : TextView = findViewById(R.id.tv_ename)
        val dname : TextView = findViewById(R.id.tv_dept)
        val epos : TextView = findViewById(R.id.tv_pos)
        if (data != null) {
            eno.text = data.e_no
            ename.text = data.e_name
            dname.text = data.d_name
            epos.text = data.e_pos
        }
    }
}