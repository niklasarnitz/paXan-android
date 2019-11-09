package com.swdec.paxan.setup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.preference.PreferenceManager
import com.swdec.paxan.R

class SetupPlanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_plan)

        findViewById<Button>(R.id.continueBtn).setOnClickListener {
            val prefs = PreferenceManager.getDefaultSharedPreferences(this)
            prefs.edit().putString("plan_spinner_1", findViewById<Spinner>(R.id.plan_1).selectedItem.toString()).apply()
            prefs.edit().putString("plan_spinner_2", findViewById<Spinner>(R.id.plan_2).selectedItem.toString()).apply()
            prefs.edit().putString("plan_spinner_3", findViewById<Spinner>(R.id.plan_3).selectedItem.toString()).apply()
            startActivity(Intent(this, SetupFinishActivity::class.java))
        }
    }
}
