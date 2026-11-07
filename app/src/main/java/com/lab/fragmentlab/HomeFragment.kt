package com.lab.fragmentlab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    // onCreateView se llama cuando el Fragment necesita crear su Vista
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout XML y lo convierte en un objeto View
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // onViewCreated se llama cuando la Vista ya está lista para interactuar
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etName = view.findViewById<EditText>(R.id.et_name)
        val btnGo  = view.findViewById<Button>(R.id.btn_go_detail)

        btnGo.setOnClickListener {
            val name = etName.text.toString().trim()

            // Crear un Bundle para enviar el nombre al siguiente Fragment
            val args = Bundle().apply {
                putString("USER_NAME", name.ifEmpty { "Mundo" })
            }

            // Crear el DetailFragment y pasarle los argumentos
            val detailFragment = DetailFragment().apply {
                arguments = args
            }

            // Reemplazar el Fragment actual con el de detalle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)  // permite volver con el botón Back
                .commit()
        }
    }
}