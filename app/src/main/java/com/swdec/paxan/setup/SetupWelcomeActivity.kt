package com.swdec.paxan.setup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.swdec.paxan.R

class SetupWelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_welcome)

        findViewById<Button>(R.id.continueBtn).setOnClickListener {
            startActivity(Intent(this, SetupNameActivity::class.java))
        }
    }
}
