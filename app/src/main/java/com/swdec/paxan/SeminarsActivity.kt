package com.swdec.paxan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class SeminarsActivity : AppCompatActivity() {

    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seminars)

        listView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(
            this,
            R.layout.list_item_seminar,
            R.id.text1,
            arrayOf(resources.getString(R.string.loading))
        )
        listView!!.adapter = adapter
        Data(this).loadSeminarTitles(requestCallback)
    }

    private val requestCallback = object : Data.SeminarCallback {
        override fun onTitlesLoaded(context: Context, titles: Array<String>) {
            val adapter = ArrayAdapter(
                context,
                R.layout.list_item_seminar,
                R.id.text1,
                titles
            )
            listView!!.adapter = adapter
            listView!!.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                startActivity(Intent(context, SeminarDetailActivity::class.java).putExtra("position", position))
            }
        }

        override fun onEntryLoaded(
            context: Context,
            title: String,
            speaker: String,
            room: String,
            description: String,
            lat: String,
            long: String
        ) {}
    }
}
