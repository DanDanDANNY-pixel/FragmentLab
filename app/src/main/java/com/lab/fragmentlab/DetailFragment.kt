package com.lab.fragmentlab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvGreeting = view.findViewById<TextView>(R.id.tv_greeting)
        val btnBack    = view.findViewById<Button>(R.id.btn_back)

        // Recuperar el nombre enviado desde HomeFragment vía Bundle
        val name = arguments?.getString("USER_NAME") ?: "Mundo"
        tvGreeting.text = "¡Hola, $name!"

        // Volver al Fragment anterior (HomeFragment)
        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}