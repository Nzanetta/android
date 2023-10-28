package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registrar()
        home()
    }

    private fun home() {
        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        btnIniciar.setOnClickListener {
            Toast.makeText(applicationContext, "Validando Credenciales...", Toast.LENGTH_SHORT)
                .show()
            val HomeActivity = Intent(applicationContext, HomeActivity::class.java)
            startActivity(HomeActivity)
        }}

            private fun registrar() {
                val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
                btnRegistrar.setOnClickListener {
                    val registrarActivity = Intent(applicationContext, RegistrarActivity::class.java)
                    startActivity(registrarActivity)
}}}








