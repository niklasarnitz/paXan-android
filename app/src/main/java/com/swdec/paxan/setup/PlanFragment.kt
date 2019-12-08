package com.swdec.paxan.setup

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.swdec.paxan.R

class PlanFragment : Fragment() {

    private var prefs: SharedPreferences? = null
    private var plan1: Spinner? = null
    private var plan2: Spinner? = null
    private var plan3: Spinner? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_setup_plan, container, false)
        prefs = PreferenceManager.getDefaultSharedPreferences(context)
        plan1 = root.findViewById(R.id.plan_1)
        plan2 = root.findViewById(R.id.plan_2)
        plan3 = root.findViewById(R.id.plan_3)
        return root
    }

    override fun onResume() {
        super.onResume()
        val plan1SpinnerArrayAdapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.plan_spinner_1))
        val plan2SpinnerArrayAdapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.plan_spinner_2))
        val plan3SpinnerArrayAdapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.plan_spinner_3))

        plan1!!.setSelection(plan1SpinnerArrayAdapter.getPosition(prefs!!.getString("plan_spinner_1", "")))
        plan2!!.setSelection(plan2SpinnerArrayAdapter.getPosition(prefs!!.getString("plan_spinner_2", "")))
        plan3!!.setSelection(plan3SpinnerArrayAdapter.getPosition(prefs!!.getString("plan_spinner_3", "")))
    }

    override fun onPause() {
        super.onPause()
        prefs!!.edit().putString("plan_spinner_1", plan1!!.selectedItem.toString()).apply()
        prefs!!.edit().putString("plan_spinner_2", plan2!!.selectedItem.toString()).apply()
        prefs!!.edit().putString("plan_spinner_3", plan3!!.selectedItem.toString()).apply()
    }
}