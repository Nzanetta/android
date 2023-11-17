package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast


import com.google.firebase.auth.FirebaseAuth
enum class ProviderType{
    BASIC
}
class HomeActivity : AppCompatActivity() {
    private lateinit var txtEmail: String
    private lateinit var providerTextView: String
    private lateinit var logOutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        logOutButton = findViewById(R.id.logOutButton)

        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")

        inventario()
        noticias()
        listar()
    }

    private fun setup(email: String, provider: String) {
        txtEmail = email
        providerTextView = provider

        logOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }

    private fun inventario() {
        val btnInventario = findViewById<Button>(R.id.btnInventario)
        btnInventario.setOnClickListener {
            Toast.makeText(applicationContext, "Cargando Inventario...", Toast.LENGTH_SHORT)
                .show()
            val inventarioActivity = Intent(this@HomeActivity, inventarioActivity::class.java)
            startActivity(inventarioActivity)
        }
    }

    private fun noticias() {
        val btnNoticias = findViewById<Button>(R.id.btnNoticias)
        btnNoticias.setOnClickListener {
            val noticiasActivity = Intent(this@HomeActivity, NoticiasActivity::class.java)
            startActivity(noticiasActivity)
        }
    }

    private fun listar() {
        val btnListar = findViewById<Button>(R.id.btnListar)
        btnListar.setOnClickListener {
            val crudActivity = Intent(this@HomeActivity, CrudActivity::class.java)
            startActivity(crudActivity)
        }
    }
}
