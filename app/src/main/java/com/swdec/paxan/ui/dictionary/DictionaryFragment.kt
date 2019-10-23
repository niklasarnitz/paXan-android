package com.swdec.paxan.ui.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.swdec.paxan.R

class DictionaryFragment : Fragment() {

    private lateinit var dictionaryViewModel: DictionaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dictionaryViewModel =
            ViewModelProviders.of(this).get(DictionaryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dictionary, container, false)
        val listView: ListView = root.findViewById(R.id.listView)
        val values = resources.getStringArray(R.array.dictionary_items)
        val adapter = ArrayAdapter<String>(
            context!!,
            R.layout.list_item_dictionary,
            R.id.text1,
            values
        )
        listView.adapter = adapter
        return root
    }
}