package com.swdec.paxan.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.swdec.paxan.R

class PlanFragment : Fragment() {

    private var plan1: Spinner? = null
    private var plan2: Spinner? = null
    private var plan3: Spinner? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_setup_plan, container, false)
        plan1 = root.findViewById(R.id.plan_1)
        plan2 = root.findViewById(R.id.plan_2)
        plan3 = root.findViewById(R.id.plan_3)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().putString("plan_spinner_1", plan1!!.selectedItem.toString()).apply()
        prefs.edit().putString("plan_spinner_2", plan2!!.selectedItem.toString()).apply()
        prefs.edit().putString("plan_spinner_3", plan3!!.selectedItem.toString()).apply()
    }
}