package com.erp.project.mainpage

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.erp.project.R
import com.erp.project.attend.AttendActivity
import com.erp.project.calender.CalendarActivity
import com.erp.project.chat.ChatMainActivity
import com.erp.project.login.DataConstructor
import com.erp.project.myinfo.MyInfoActivity
import com.erp.project.noticeboard.DeptNoticeActivity
import com.erp.project.noticeboard.NoticeBoardActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var data : DataConstructor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data  = intent.getParcelableExtra("Data")!!
        val eno : TextView = findViewById(R.id.tv_id)
        val ename : TextView = findViewById(R.id.tv_ename)
        val dname : TextView = findViewById(R.id.tv_dept)
        val epos : TextView = findViewById(R.id.tv_pos)
        eno.text = data.e_no
        ename.text = data.e_name
        dname.text = data.d_name
        epos.text = data.e_pos
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
        clickCalendar.putExtra("data", data);
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

    fun clickBoards(view: View) {
        val tablayout: TabLayout = findViewById(R.id.main_tab_board)
        var nextBoard = Intent(this, NoticeBoardActivity::class.java)
        if (tablayout.getTabAt(0)!!.isSelected) {
            startActivity(nextBoard)
        }
        else {
            nextBoard = Intent(this, DeptNoticeActivity::class.java)
            startActivity(nextBoard)
        }
    }


}
