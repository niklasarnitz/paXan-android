package com.swdec.paxan.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.swdec.paxan.R
import android.widget.TextView
import androidx.preference.PreferenceManager
import com.swdec.paxan.settings.SettingsPlanActivity

class PlanFragment : Fragment() {

    private var plan1: TextView? = null
    private var plan2: TextView? = null
    private var plan3: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_plan, container, false)
        plan1 = root.findViewById(R.id.plan_1_txt)
        plan2 = root.findViewById(R.id.plan_2_txt)
        plan3 = root.findViewById(R.id.plan_3_txt)
        root.findViewById<Button>(R.id.planBtn).setOnClickListener {
            startActivity(Intent(context, SettingsPlanActivity::class.java))
        }
        return root
    }

    override fun onResume() {
        super.onResume()
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        plan1!!.text = prefs.getString("plan_spinner_1", resources.getString(R.string.error))
        plan2!!.text = prefs.getString("plan_spinner_2", resources.getString(R.string.error))
        plan3!!.text = prefs.getString("plan_spinner_3", resources.getString(R.string.error))
    }
}