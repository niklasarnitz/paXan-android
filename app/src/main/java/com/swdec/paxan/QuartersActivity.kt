package com.swdec.paxan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class QuartersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quarters)

        findViewById<Button>(R.id.dobeltalschule).setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=48.805071,8.449980"))
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        findViewById<Button>(R.id.bronnenwiesenhalle).setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=48.816815,8.481872"))
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        findViewById<Button>(R.id.kindergarten).setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=48.796287,8.492539"))
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        findViewById<Button>(R.id.schule).setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=48.797579,8.494003"))
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}
