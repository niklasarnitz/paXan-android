package com.swdec.paxan.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.swdec.paxan.R
import com.swdec.paxan.Data
import com.swdec.paxan.DictionaryActivity


class DictionaryFragment : Fragment() {

    private var listView: ListView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main_dictionary, container, false)
        listView = root.findViewById(R.id.listView)
        val adapter = ArrayAdapter<String>(
            context!!,
            R.layout.list_item_dictionary,
            R.id.text1,
            arrayOf(resources.getString(R.string.loading))
        )
        listView!!.adapter = adapter
        Data(context!!).loadDictionaryTitles(requestCallback)
        return root
    }

    private val requestCallback = object : Data.DictionaryCallback {
        override fun onTitlesLoaded(context: Context, titles: Array<String>) {
            val adapter = ArrayAdapter<String>(
                context,
                R.layout.list_item_dictionary,
                R.id.text1,
                titles
            )
            listView!!.adapter = adapter
            listView!!.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                startActivity(Intent(context, DictionaryActivity::class.java).putExtra("position", position))
            }
        }
        override fun onEntryLoaded(context: Context, title: String, description: String) {}
    }
}