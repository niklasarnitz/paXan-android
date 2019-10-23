package com.swdec.paxan.ui.plan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.swdec.paxan.R

class PlanFragment : Fragment() {

    private lateinit var planViewModel: PlanViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        planViewModel =
            ViewModelProviders.of(this).get(PlanViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_plan, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        planViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}