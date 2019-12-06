package com.swdec.paxan.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.swdec.paxan.R

class NameFragment : Fragment() {

    private var nameTxt: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_setup_name, container, false)
        nameTxt = root.findViewById(R.id.nameTxt)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("name", nameTxt!!.text.toString()).apply()
    }
}