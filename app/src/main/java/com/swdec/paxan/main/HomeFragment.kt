package com.swdec.paxan.main

import android.os.Bundle
import androidx.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.swdec.paxan.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val prefs = PreferenceManager.getDefaultSharedPreferences(context!!)
        var name = prefs.getString("name", "Gast") ?:"Gast"
        if (name == "") name = "Gast"
        root.findViewById<TextView>(R.id.titleTxt).text = resources.getString(R.string.home_title, name)
        return root
    }
}