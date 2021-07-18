package com.erp.project.calender

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.erp.project.R
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialCalendar
import com.google.android.material.datepicker.MaterialDatePicker
import com.prolificinteractive.materialcalendarview.*
import kotlinx.android.synthetic.main.activity_calendar.*
import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private val formatter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        DateTimeFormatter.ofPattern("EEE, d MMM yyyy")
    } else {
        TODO("VERSION.SDK_INT < O")
    }

    private val nowDate: LocalDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDate.MIN
    } else {
        TODO("VERSION.SDK_INT < O")
    }
    private lateinit var widget: MaterialCalendarView
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        widget = findViewById(R.id.calendar_custom)
        textView = findViewById(R.id.calendar_text)
        widget.setOnDateChangedListener { widget, date, selected ->
            if (selected) {
                textView.text = date.toString()
            } else {
                textView.text = "No Selected"
            }

        }
    }
}





