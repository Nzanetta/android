package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        inventario()
        noticias()
        listar()
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
        }}

        private fun listar() {
            val btnListar = findViewById<Button>(R.id.btnListar)
            btnListar.setOnClickListener {
                val crudActivity = Intent(this@HomeActivity, CrudActivity::class.java)
                startActivity(crudActivity)
            }
    }
}
