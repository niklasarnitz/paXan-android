package com.swdec.paxan.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.preference.PreferenceManager
import com.swdec.paxan.R

class SettingsNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_name)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val nameTxt = findViewById<EditText>(R.id.nameTxt)

        nameTxt.setText(prefs.getString("name", resources.getString(R.string.default_name)))

        findViewById<Button>(R.id.continueBtn).setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(this).edit().putString("name", nameTxt.text.toString()).apply()
            finish()
        }
    }
}
