package com.swdec.paxan.setup

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.swdec.paxan.R

class NameFragment : Fragment() {

    private var prefs: SharedPreferences? = null
    private var nameTxt: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_setup_name, container, false)
        prefs = PreferenceManager.getDefaultSharedPreferences(context)
        nameTxt = root.findViewById(R.id.nameTxt)
        return root
    }

    override fun onResume() {
        super.onResume()
        nameTxt!!.setText(prefs!!.getString("name", "") ?:"")
    }

    override fun onPause() {
        super.onPause()
        prefs!!.edit().putString("name", nameTxt!!.text.toString()).apply()
    }
}