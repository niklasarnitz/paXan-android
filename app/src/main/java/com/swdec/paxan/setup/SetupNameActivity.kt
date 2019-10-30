package com.swdec.paxan.setup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.swdec.paxan.R

class SetupNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_name)

        findViewById<Button>(R.id.continueBtn).setOnClickListener {
            startActivity(Intent(this, SetupPlanActivity::class.java))
        }
    }
}
