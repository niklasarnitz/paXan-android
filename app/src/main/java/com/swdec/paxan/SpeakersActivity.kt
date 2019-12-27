package com.swdec.paxan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class SpeakersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speakers)

        val listView: ListView = findViewById(R.id.listView)
        val values = resources.getStringArray(R.array.dummy_array)
        val adapter = ArrayAdapter<String>(
            this,
            R.layout.list_item_speakers,
            R.id.text1,
            values
        )
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            //startActivity(Intent(this, SpeakerDetailActivity::class.java).putExtra("position", position))
        }
    }
}
