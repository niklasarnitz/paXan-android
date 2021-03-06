package com.swdec.paxan

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SeminarDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seminar_detail)

        val data = Data(this)
        val position = intent.getIntExtra("position", -1)
        if (position == -1) {
            val title = intent.getStringExtra("title") ?: ""
            data.loadSeminarEntryByTitle(requestCallback, title)
        } else {
            data.loadSeminarEntry(requestCallback, position)
        }
    }


    private val requestCallback = object : Data.SeminarCallback {
        override fun onTitlesLoaded(context: Context, titles: Array<String>) {}
        override fun onEntryLoaded(
            context: Context,
            title: String,
            subtitle: String,
            speaker: String,
            room: String,
            lat: String,
            long: String
        ) {
            findViewById<TextView>(R.id.titleTxt).text = title
            findViewById<TextView>(R.id.subtitle).text = subtitle
            findViewById<TextView>(R.id.speaker).text = resources.getString(R.string.seminar_detail_speaker, speaker)
            findViewById<TextView>(R.id.room).text = resources.getString(R.string.seminar_detail_room, room)
            findViewById<Button>(R.id.navigateBtn).setOnClickListener {
                val gmmIntentUri: Uri =
                    Uri.parse("google.navigation:q=$lat,$long&mode=w")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
        }
    }
}
