package com.erp.project.mainpage

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.erp.project.R
import com.erp.project.attend.AttendActivity
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        noticeTable()
    }

    private fun noticeTable() {

        val boardAdapter = MainFragmentAdapter(supportFragmentManager)
        val board = findViewById<ViewPager>(R.id.main_tab_viewpager)
        board.adapter = boardAdapter
        val tab = findViewById<TabLayout>(R.id.main_tab_board)
        tab.setSelectedTabIndicatorHeight(0)
        tab.setupWithViewPager(board)
    }

    fun tsConnect(view: View) {
        val tsbtn = findViewById<ImageView>(R.id.main_icon_attend)
        tsbtn.setOnClickListener(){
           val nextAttend = Intent(this, AttendActivity::class.java)
            startActivity(nextAttend)
        }
    }


}