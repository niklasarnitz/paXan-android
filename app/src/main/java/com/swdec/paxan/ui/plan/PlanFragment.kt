package com.swdec.paxan.ui.plan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.swdec.paxan.R
import android.widget.ArrayAdapter

class PlanFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_plan, container, false)
        val listView: ListView = root.findViewById(R.id.listView)
        val values = resources.getStringArray(R.array.plan_items)
        val adapter = ArrayAdapter<String>(
            context!!,
            R.layout.list_item_plan,
            R.id.text1,
            values
        )
        listView.adapter = adapter
        return root
    }
}