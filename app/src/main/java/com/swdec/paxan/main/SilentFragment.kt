package com.swdec.paxan.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.swdec.paxan.*

class SilentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main_silent, container, false)
        root.findViewById<Button>(R.id.friday).setOnClickListener {
            startActivity(Intent(context, BibleActivity::class.java).putExtra("day", 0))
        }
        root.findViewById<Button>(R.id.saturday).setOnClickListener {
            startActivity(Intent(context, BibleActivity::class.java).putExtra("day", 1))
        }
        root.findViewById<Button>(R.id.sunday).setOnClickListener {
            startActivity(Intent(context, BibleActivity::class.java).putExtra("day", 2))
        }
        root.findViewById<Button>(R.id.monday).setOnClickListener {
            startActivity(Intent(context, BibleActivity::class.java).putExtra("day", 3))
        }
        return root
    }
}