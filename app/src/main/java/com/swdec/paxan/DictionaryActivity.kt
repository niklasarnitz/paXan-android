package com.swdec.paxan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DictionaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dictionary)

        val position = intent.getIntExtra("position", 0)
        title = resources.getStringArray(R.array.dictionary_items)[position]
        findViewById<TextView>(R.id.textView).text = resources.getStringArray(R.array.dictionary_texts)[position]
    }
}
