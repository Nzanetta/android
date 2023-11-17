package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var rememberSwitch: Switch
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        rememberSwitch = findViewById(R.id.swRecuerdame)
        loginButton = findViewById(R.id.btn_login)
        registerButton = findViewById(R.id.btnRegistrar)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Inicio de sesión exitoso, redirige al usuario a HomeActivity.
                        val user = auth.currentUser
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish()  // Cierra la actividad actual si lo deseas.
                    } else {
                        // El inicio de sesión falló, muestra un mensaje de error en un Toast.
                        Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                    }
                })
        }

        registerButton.setOnClickListener {
            // Redirigir a la actividad de registro (RegistrarActivity).
            val intent = Intent(this, RegistrarActivity::class.java)
            startActivity(intent)
        }
    }
}
