package com.example.prueba_sonia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_sonia.AppEventos.MainActivityEventos
import com.example.prueba_sonia.AppHorario.MainActivityHorario
import com.example.prueba_sonia.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val horarioButton = findViewById<Button>(R.id.btnHorario)
        val eventosButton = findViewById<Button>(R.id.btnEventos)

        horarioButton.setOnClickListener {
            startActivity(Intent(this, MainActivityHorario::class.java))
        }

        eventosButton.setOnClickListener {
            startActivity(Intent(this, MainActivityEventos::class.java))
        }
    }
}