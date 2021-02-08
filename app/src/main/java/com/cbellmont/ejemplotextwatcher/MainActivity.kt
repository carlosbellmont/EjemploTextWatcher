package com.cbellmont.ejemplotextwatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.cbellmont.ejemplotextwatcher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bMostrarNombre.setOnClickListener {
            Log.w("TAG", "Clicked")
        }

        binding.etNombre.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(textContent: Editable?) {
                // NO usamos textContent ya que lo cogemos siempre desde el editText. Es opcional.
                Log.w("TAG", binding.etNombre.text.toString())
                textContent?.let {
                    binding.bMostrarNombre.isEnabled = binding.etNombre.text.contains(" ")
                    /* Esta es la forma equivalente a lo de arriba.
                    if (textContent.contains(" ")) {
                        binding.bMostrarNombre.isEnabled = true
                    } else {
                        binding.bMostrarNombre.isEnabled = false
                    }*/
                    // Hacer que el textView muestre el número de caracteres del nombre. Ejemplo: Carlos tiene X carácteres.
                    binding.twNombre.text = "${binding.etNombre.text} tiene ${binding.etNombre.text.count()} carácteres"
                    // Si el texto está vacío entonces tiene que poner "Introduce tu nombre:"
                    if(binding.etNombre.text.isEmpty()){
                        binding.twNombre.text = "Introduce tu nombre:"
                    }
                }
            }
        })

        binding.etNombre.setOnFocusChangeListener { vista, tieneFocus ->
            if (tieneFocus) {
                Log.w("TAG", "etNombre tiene el focus")
            } else {
                Log.w("TAG", "etNombre no tiene el focus")
            }
        }


    }
}