package com.huancahuari.andres.usolayoutsv4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.huancahuari.andres.usolayoutsv4.databinding.ActivityInfoPedidoBinding

class InfoPedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfoPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombreCliente = intent.getStringExtra("nombreCliente")
        val numeroCliente = intent.getStringExtra("numeroCliente")
        val productos = intent.getStringExtra("productos")
        val ciudad = intent.getStringExtra("ciudad")
        val direccion = intent.getStringExtra("direccion")

        // Mostrar los datos en la interfaz
        binding.txtNombreCliente.text = "Nombre: $nombreCliente"
        binding.txtNumeroCliente.text = "Número: $numeroCliente"
        binding.txtProductos.text = "Productos: $productos"
        binding.txtCiudad.text = "Ciudad: $ciudad"
        binding.txtDireccion.text = "Dirección: $direccion"
    }



}