package com.erp.project.mainpage

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.viewpager2.widget.ViewPager2
import com.erp.project.R
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

}
