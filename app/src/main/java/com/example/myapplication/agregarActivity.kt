package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class agregarActivity : AppCompatActivity() {

    private lateinit var edtCodigo: EditText
    private lateinit var edtNombre: EditText
    private lateinit var edtDescripcion: EditText
    private lateinit var btnAgregar: Button

    private lateinit var dbHelper: BD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)

        edtCodigo = findViewById(R.id.editTextCodigo)
        edtNombre = findViewById(R.id.editTextNombre)
        edtDescripcion = findViewById(R.id.editTextDescripcion)
        btnAgregar = findViewById(R.id.btnAgregar)

        dbHelper = BD(this) // Reemplaza MyDatabaseHelper con el nombre de tu clase de DBHelper

        btnAgregar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val codigo = edtCodigo.text.toString()
                val nombre = edtNombre.text.toString()
                val descripcion = edtDescripcion.text.toString()

                Toast.makeText(applicationContext, "ARMA AGREGADA", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
