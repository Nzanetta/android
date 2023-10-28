package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class splashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        acceder()
    }

    private fun acceder() {
        val btnAcceder = findViewById<Button>(R.id.btnAcceder)
        btnAcceder.setOnClickListener {
            Toast.makeText(applicationContext, "Accediendo a la aplicación", Toast.LENGTH_SHORT).show()
            val mediaLoginActivity = Intent(applicationContext, MediaLoginActivity::class.java)
            startActivity(mediaLoginActivity )
}}
}



