package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class Fragment_A : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_a, container, false)
        val btn = root.findViewById<Button>(R.id.nextBtn)
        btn.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_A_to_fragment_B)
        }
        return root
    }
}