package com.swdec.paxan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class SpeakersActivity : AppCompatActivity() {

    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speakers)

        listView = findViewById(R.id.listView)
        val adapter = ArrayAdapter<String>(
            this,
            R.layout.list_item_speakers,
            R.id.text1,
            arrayOf(resources.getString(R.string.loading))
        )
        listView!!.adapter = adapter
        Data(this).loadSpeakerTitles(requestCallback)
    }

    private val requestCallback = object : Data.SpeakerCallback {
        override fun onTitlesLoaded(context: Context, titles: Array<String>) {
            val adapter = ArrayAdapter<String>(
                context,
                R.layout.list_item_dictionary,
                R.id.text1,
                titles
            )
            listView!!.adapter = adapter
            listView!!.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                startActivity(Intent(context, SpeakerDetailActivity::class.java).putExtra("position", position))
            }
        }

        override fun onEntryLoaded(
            context: Context,
            title: String,
            organisation: String,
            website: String
        ) {}
    }
}
