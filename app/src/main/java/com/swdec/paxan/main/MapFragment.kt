package com.swdec.paxan.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.swdec.paxan.R


class MapFragment : Fragment() {
    private var mapView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main_map, container, false)
        mapView = root.findViewById(R.id.mapView)
        return root
    }
}