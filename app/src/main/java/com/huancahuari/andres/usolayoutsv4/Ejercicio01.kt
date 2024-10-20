package com.huancahuari.andres.usolayoutsv4

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio01)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun mostrarView(view: View) {
        val viewVerde = findViewById<View>(R.id.viewVerde)
        viewVerde.visibility = View.VISIBLE
    }
    fun ocultarView(view: View) {
        val viewVerde = findViewById<View>(R.id.viewVerde)
        viewVerde.visibility = View.GONE
    }
}