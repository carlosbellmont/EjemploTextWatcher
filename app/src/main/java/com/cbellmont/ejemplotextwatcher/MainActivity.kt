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
                Log.w("TAG", textContent.toString())
                textContent?.let {
                    binding.bMostrarNombre.isEnabled = textContent.contains(" ")
                    /* Esta es la forma equivalente a lo de arriba.
                    if (textContent.contains(" ")) {
                        binding.bMostrarNombre.isEnabled = true
                    } else {
                        binding.bMostrarNombre.isEnabled = false
                    }*/
                }
            }
        })
    }
}