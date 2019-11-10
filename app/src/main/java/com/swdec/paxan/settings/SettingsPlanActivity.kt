package com.swdec.paxan.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.preference.PreferenceManager
import com.swdec.paxan.R

class SettingsPlanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_plan)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val plan1 = findViewById<Spinner>(R.id.plan_1)
        val plan2 = findViewById<Spinner>(R.id.plan_2)
        val plan3 = findViewById<Spinner>(R.id.plan_3)
        val plan1SpinnerArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.plan_spinner_1))
        val plan2SpinnerArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.plan_spinner_2))
        val plan3SpinnerArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.plan_spinner_3))

        plan1.setSelection(plan1SpinnerArrayAdapter.getPosition(prefs.getString("plan_spinner_1", "")))
        plan2.setSelection(plan2SpinnerArrayAdapter.getPosition(prefs.getString("plan_spinner_2", "")))
        plan3.setSelection(plan3SpinnerArrayAdapter.getPosition(prefs.getString("plan_spinner_3", "")))

        findViewById<Button>(R.id.continueBtn).setOnClickListener {
            prefs.edit().putString("plan_spinner_1", plan1.selectedItem.toString()).apply()
            prefs.edit().putString("plan_spinner_2", plan2.selectedItem.toString()).apply()
            prefs.edit().putString("plan_spinner_3", plan3.selectedItem.toString()).apply()
            finish()
        }
    }
}
