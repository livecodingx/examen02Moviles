package com.huancahuari.andres.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
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

        binding.txtNombreCliente.text = "Nombre: $nombreCliente"
        binding.txtNumeroCliente.text = "Número: $numeroCliente"
        binding.txtProductos.text = "Productos: $productos"
        binding.txtCiudad.text = "Ciudad: $ciudad"
        binding.txtDireccion.text = "Dirección: $direccion"

        binding.btnLlamar.setOnClickListener {
            if (numeroCliente.isNullOrEmpty()) {
                Toast.makeText(this, "Número de teléfono no disponible", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$numeroCliente")
                }
                startActivity(intent)
            }
        }

        binding.btnWsp.setOnClickListener {
            if (nombreCliente.isNullOrEmpty() || productos.isNullOrEmpty() || direccion.isNullOrEmpty()) {
                Toast.makeText(this, "Falta información para enviar mensaje de WhatsApp", Toast.LENGTH_SHORT).show()
            } else {
                val mensaje = "Hola $nombreCliente, Tus productos: $productos están en camino a la dirección: $direccion"
                val uri = Uri.parse("https://wa.me/?text=$mensaje")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }

        binding.btnMaps.setOnClickListener {
            if (direccion.isNullOrEmpty()) {
                Toast.makeText(this, "Dirección no disponible", Toast.LENGTH_SHORT).show()
            } else {
                val gmmIntentUri = Uri.parse("geo:0,0?q=$direccion")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
        }
    }
}