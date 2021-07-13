package com.erp.project.mainpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erp.project.R
class MainEmpBoardFragment : Fragment() {

    fun fragInstance() : MainEmpBoardFragment{
        val args = Bundle()
        val frag = MainEmpBoardFragment()
        frag.arguments=args
        return frag
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_emp_board, container, false)
    }
}