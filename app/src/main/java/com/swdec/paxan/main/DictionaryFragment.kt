package com.swdec.paxan.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.swdec.paxan.R
import android.widget.AdapterView.OnItemClickListener
import com.swdec.paxan.DictionaryActivity


class DictionaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main_dictionary, container, false)
        val listView: ListView = root.findViewById(R.id.listView)
        val values = resources.getStringArray(R.array.dictionary_items)
        val adapter = ArrayAdapter<String>(
            context!!,
            R.layout.list_item_dictionary,
            R.id.text1,
            values
        )
        listView.adapter = adapter
        listView.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            startActivity(Intent(context!!, DictionaryActivity::class.java).putExtra("position", position))
        }
        return root
    }
}