package com.swdec.paxan.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.swdec.paxan.*

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main_info, container, false)
        root.findViewById<Button>(R.id.speakers).setOnClickListener {
            startActivity(Intent(context, SpeakersActivity::class.java))
        }
        root.findViewById<Button>(R.id.seminars).setOnClickListener {
            startActivity(Intent(context, SeminarsActivity::class.java))
        }
        root.findViewById<Button>(R.id.donate).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.swdec.de/spenden/")))
        }
        root.findViewById<Button>(R.id.quarters).setOnClickListener {
            startActivity(Intent(context, QuartersActivity::class.java))
        }
        root.findViewById<Button>(R.id.about).setOnClickListener {
            startActivity(Intent(context, AboutActivity::class.java))
        }
        return root
    }
}