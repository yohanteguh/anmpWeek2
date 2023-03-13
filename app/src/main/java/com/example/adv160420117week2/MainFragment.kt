package com.example.adv160420117week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val startBtn = view.findViewById<Button>(R.id.btnStart)
        startBtn.setOnClickListener {
            val name = view.findViewById<EditText>(R.id.txtName)
            val action = MainFragmentDirections.actionGameFragment(name.text.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
}