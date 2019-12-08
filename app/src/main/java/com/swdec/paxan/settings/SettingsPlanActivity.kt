package com.swdec.paxan.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.swdec.paxan.R

class SettingsPlanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_plan)

        findViewById<Button>(R.id.continueBtn).setOnClickListener {
            finish()
        }
    }
}
