package com.erp.project.mainpage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erp.project.R

class MainNoticeBoardFragment : Fragment() {

    fun fragInstance() : MainNoticeBoardFragment {
        val args = Bundle()
        val frag = MainNoticeBoardFragment()
        frag.arguments=args
        return frag
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_notice_board, container, false)
    }

}