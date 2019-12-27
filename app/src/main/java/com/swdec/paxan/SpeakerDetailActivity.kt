package com.swdec.paxan

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SpeakerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speaker_detail)

        val position = intent.getIntExtra("position", 0)
        Data(this).loadSpeakerEntry(requestCallback, position)
    }

    private val requestCallback = object : Data.SpeakerCallback {
        override fun onTitlesLoaded(context: Context, titles: Array<String>) {}
        override fun onEntryLoaded(
            context: Context,
            title: String,
            organisation: String,
            website: String
        ) {
            findViewById<TextView>(R.id.titleTxt).text = title
            findViewById<TextView>(R.id.organisation).text = context.resources.getString(R.string.speaker_detail_organisation, organisation)
            findViewById<TextView>(R.id.website).text = context.resources.getString(R.string.speaker_detail_website, website)
        }
    }
}
