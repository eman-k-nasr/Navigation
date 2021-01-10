package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.navigation.model.User

class Fragment_A : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_a, container, false)
        val btn = root.findViewById<Button>(R.id.nextBtn)
        val nameEt = root.findViewById<EditText>(R.id.nameEt)
        val jobEt = root.findViewById<EditText>(R.id.jobEt)
        btn.setOnClickListener {
            val name = nameEt.text.toString()
            val job = jobEt.text.toString()
            val user = User(name,job)
            val action = Fragment_ADirections.actionFragmentAToFragmentB(user)
            it.findNavController().navigate(action)
        }
        return root
    }
}