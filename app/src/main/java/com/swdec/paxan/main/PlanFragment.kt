package com.swdec.paxan.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.swdec.paxan.R
import android.widget.TextView
import androidx.preference.PreferenceManager
import com.swdec.paxan.SeminarDetailActivity
import com.swdec.paxan.settings.SettingsPlanActivity

class PlanFragment : Fragment() {

    private var plan1: TextView? = null
    private var plan2: TextView? = null
    private var plan3: TextView? = null
    private var plan1Click: LinearLayout? = null
    private var plan2Click: LinearLayout? = null
    private var plan3Click: LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main_plan, container, false)
        plan1 = root.findViewById(R.id.plan_1_txt)
        plan2 = root.findViewById(R.id.plan_2_txt)
        plan3 = root.findViewById(R.id.plan_3_txt)
        plan1Click = root.findViewById(R.id.plan_1_click)
        plan2Click = root.findViewById(R.id.plan_2_click)
        plan3Click = root.findViewById(R.id.plan_3_click)
        root.findViewById<Button>(R.id.planBtn).setOnClickListener {
            startActivity(Intent(context, SettingsPlanActivity::class.java))
        }
        return root
    }

    override fun onResume() {
        super.onResume()
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val title1 = prefs.getString("plan_spinner_1", resources.getString(R.string.error))
        val title2 = prefs.getString("plan_spinner_2", resources.getString(R.string.error))
        val title3 = prefs.getString("plan_spinner_3", resources.getString(R.string.error))

        plan1!!.text = title1
        plan2!!.text = title2
        plan3!!.text = title3

        plan1Click!!.setOnClickListener {
            startActivity(Intent(context, SeminarDetailActivity::class.java).putExtra("title", title1))
        }
        plan2Click!!.setOnClickListener {
            startActivity(Intent(context, SeminarDetailActivity::class.java).putExtra("title", title2))
        }
        plan3Click!!.findViewById<LinearLayout>(R.id.plan_3_click).setOnClickListener {
            startActivity(Intent(context, SeminarDetailActivity::class.java).putExtra("title", title3))
        }
    }
}