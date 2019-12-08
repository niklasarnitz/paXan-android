package com.swdec.paxan.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.swdec.paxan.R

class SettingsNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_name)

        findViewById<Button>(R.id.continueBtn).setOnClickListener {
            finish()
        }
    }
}
