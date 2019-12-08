package com.swdec.paxan.main

import android.content.Intent
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.swdec.paxan.R
import com.swdec.paxan.settings.SettingsNameActivity

class HomeFragment : Fragment() {

    private var titleTxt: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main_home, container, false)
        titleTxt = root.findViewById(R.id.titleTxt)
        root.findViewById<Button>(R.id.nameBtn).setOnClickListener {
            startActivity(Intent(context, SettingsNameActivity::class.java))
        }
        return root
    }

    override fun onResume() {
        super.onResume()
        val prefs = PreferenceManager.getDefaultSharedPreferences(context!!)
        val defaultName = resources.getString(R.string.default_name)
        var name = prefs.getString("name", defaultName) ?:defaultName
        if (name == "") name = defaultName
        titleTxt!!.text = resources.getString(R.string.home_title, name)
    }
}