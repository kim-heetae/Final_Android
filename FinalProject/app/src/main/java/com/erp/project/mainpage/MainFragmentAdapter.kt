package com.erp.project.mainpage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainFragmentAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm) {
    //Fragment 만들 갯수
    override fun getCount(): Int = 2

    //Fragment 페이지 설정
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MainNoticeBoardFragment().fragInstance()
            1 -> MainEmpBoardFragment().fragInstance()
            else -> MainNoticeBoardFragment().fragInstance()
        }
    }
    //Fragment 이름.
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 ->"공지사항"
            1 ->"업무사항"
            else -> "main"
        }
    }
}