package com.swdec.paxan

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DictionaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dictionary)

        val position = intent.getIntExtra("position", 0)
        Data(this).loadDictionaryEntry(requestCallback, position)
    }

    private val requestCallback = object : Data.DictionaryCallback {
        override fun onTitlesLoaded(context: Context, titles: Array<String>) {}
        override fun onEntryLoaded(context: Context, title: String, description: String) {
            findViewById<TextView>(R.id.titleTxt).text = title
            findViewById<TextView>(R.id.textView).text = description
        }
    }
}
