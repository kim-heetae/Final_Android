package com.erp.project.mainpage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.erp.project.mainpage.fragment.MainEmpBoardFragment
import com.erp.project.mainpage.fragment.MainNoticeBoardFragment


class MainFragmentAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    //Fragment 만들 갯수
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MainNoticeBoardFragment()
            }
            1 -> {
                MainEmpBoardFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}