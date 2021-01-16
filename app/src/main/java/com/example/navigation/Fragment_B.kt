package com.example.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_b.*

class Fragment_B: Fragment() {
    val args: Fragment_BArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_b, container, false)
        val nameTv = root.findViewById<TextView>(R.id.nameTv)
        val jobTv = root.findViewById<TextView>(R.id.jobTv)
        val goBtn = root.findViewById<Button>(R.id.goBtn)
        goBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_B_to_fragment_C)
        }
        val user = args.user
        nameTv.text = user.name
        jobTv.text = user.job
        return root
    }
}