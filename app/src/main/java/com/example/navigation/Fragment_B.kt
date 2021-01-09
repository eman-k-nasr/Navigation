package com.example.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class Fragment_B: Fragment() {
    val args: Fragment_BArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_b, container, false)
        val nameTv = root.findViewById<TextView>(R.id.nameTv)
        val name = args.name
        nameTv.text = name
        return root
    }
}