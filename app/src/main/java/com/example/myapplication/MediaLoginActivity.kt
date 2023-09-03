package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MediaLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_login)

        login()
    }

    private fun login() {
        val btnLogin = findViewById<Button>(R.id.btnLoginPrincipal)
        btnLogin.setOnClickListener {
            Toast.makeText(applicationContext, "Accediendo a la aplicación", Toast.LENGTH_SHORT).show()
            val ventanaMain = Intent(applicationContext, MainActivity::class.java)
            startActivity(ventanaMain)
         }
    }
}