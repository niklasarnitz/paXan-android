package com.swdec.paxan.ui.plan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.swdec.paxan.R
import android.widget.ArrayAdapter



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
        val listView: ListView = root.findViewById(R.id.listView)
        val values = resources.getStringArray(R.array.plan_items)
        val adapter = ArrayAdapter<String>(
            context!!,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            values
        )
        listView.adapter = adapter
        return root
    }
}