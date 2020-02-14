package com.swdec.paxan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BibleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bible)

        val text = findViewById<TextView>(R.id.text)

        when (intent.getIntExtra("day", 0)) {
            0 -> {
                title = resources.getString(R.string.bible_friday)
                text.text = resources.getString(R.string.bible_friday_text)
            }
            1 -> {
                title = resources.getString(R.string.bible_saturday)
                text.text = resources.getString(R.string.bible_saturday_text)
            }
            2 -> {
                title = resources.getString(R.string.bible_sunday)
                text.text = resources.getString(R.string.bible_sunday_text)
            }
            3 -> {
                title = resources.getString(R.string.bible_monday)
                text.text = resources.getString(R.string.bible_monday_text)
            }
        }
    }
}
