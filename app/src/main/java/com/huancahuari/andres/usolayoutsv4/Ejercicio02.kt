package com.huancahuari.andres.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.huancahuari.andres.usolayoutsv4.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding
    private lateinit var contactListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegistrar.setOnClickListener {
            // Validar campos
            val nombreCliente = binding.etNombreCliente.text.toString()
            val numeroCliente = binding.etNumeroCliente.text.toString()
            val productos = binding.etProductos.text.toString()
            val ciudad = binding.etCiudad.text.toString()
            val direccion = binding.etDireccion.text.toString()

            if (validarCampos(nombreCliente, numeroCliente, productos, ciudad, direccion)) {
                // Si todos los campos están llenos, redirigir a otra actividad
                val intent = Intent(this, InfoPedidoActivity::class.java).apply {
                    putExtra("nombreCliente", nombreCliente)
                    putExtra("numeroCliente", numeroCliente)
                    putExtra("productos", productos)
                    putExtra("ciudad", ciudad)
                    putExtra("direccion", direccion)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //validar los campos completos
    private fun validarCampos(
        nombreCliente: String,
        numeroCliente: String,
        productos: String,
        ciudad: String,
        direccion: String
    ): Boolean {
        return nombreCliente.isNotEmpty() && numeroCliente.isNotEmpty() && productos.isNotEmpty() &&
                ciudad.isNotEmpty() && direccion.isNotEmpty()
    }
}