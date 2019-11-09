package com.swdec.paxan.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.swdec.paxan.R
import android.widget.TextView
import androidx.preference.PreferenceManager

class PlanFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_plan, container, false)
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        root.findViewById<TextView>(R.id.plan_1_txt).text = prefs.getString("plan_spinner_1", resources.getString(R.string.error))
        root.findViewById<TextView>(R.id.plan_2_txt).text = prefs.getString("plan_spinner_2", resources.getString(R.string.error))
        root.findViewById<TextView>(R.id.plan_3_txt).text = prefs.getString("plan_spinner_3", resources.getString(R.string.error))
        return root
    }
}