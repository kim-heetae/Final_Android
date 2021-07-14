package com.erp.project.mainpage

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.viewpager2.widget.ViewPager2
import com.erp.project.R
import com.erp.project.attend.AttendActivity
import com.erp.project.calender.CalendarActivity
import com.erp.project.chat.ChatMainActivity
import com.erp.project.myinfo.MyInfoActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        noticeTable()

    }


    private fun noticeTable() {
        val tabLayout = findViewById<TabLayout>(R.id.main_tab_board)
        val viewPager2 = findViewById<ViewPager2>(R.id.main_tab_viewpager2)
        val adapter = MainFragmentAdapter(supportFragmentManager, lifecycle)
        tabLayout.setSelectedTabIndicatorHeight(0)
        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "공지사항"
                }
                1 -> {
                    tab.text = "업무사항"
                }
            }
        }.attach()
    }

    fun clickCalendar(view: View) {
        val clickCalendar = Intent(this, CalendarActivity::class.java)
        startActivity(clickCalendar)
    }
    fun clickAttend(view: View) {
        val clickAttend = Intent(this, AttendActivity::class.java)
        startActivity(clickAttend)
    }
    fun clickMyInfo(view: View) {
        val clickMyInfo = Intent(this, MyInfoActivity::class.java)
        startActivity(clickMyInfo)
    }
    fun clickChat(view: View) {
        val clickChat = Intent(this, ChatMainActivity::class.java)
        startActivity(clickChat)
    }

}
