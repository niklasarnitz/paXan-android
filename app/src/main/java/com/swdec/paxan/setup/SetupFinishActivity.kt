package com.swdec.paxan.setup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.swdec.paxan.MainActivity
import com.swdec.paxan.R

class SetupFinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_finish)

        findViewById<Button>(R.id.continueBtn).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
