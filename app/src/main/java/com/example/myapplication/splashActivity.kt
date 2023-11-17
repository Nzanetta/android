package com.example.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class splashActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Inicializa el MediaPlayer con la música
        mediaPlayer = MediaPlayer.create(this, R.raw.song_csgo)

        // Comienza la reproducción de la música
        mediaPlayer?.start()

        acceder()
    }

    private fun acceder() {
        val btnAcceder = findViewById<Button>(R.id.btnAcceder)
        btnAcceder.setOnClickListener {
            // Detiene la reproducción de la música antes de iniciar MediaLoginActivity
            mediaPlayer?.stop()
            mediaPlayer?.release()

            val mediaLoginActivity = Intent(applicationContext, MediaLoginActivity::class.java)
            startActivity(mediaLoginActivity)
        }}


    override fun onDestroy() {
        super.onDestroy()
    }}
