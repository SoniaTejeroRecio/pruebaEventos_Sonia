package com.example.prueba_sonia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_sonia.AppEventos.EventListActivity
import com.example.prueba_sonia.AppHorario.MainActivityHorario

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHorario = findViewById<Button>(R.id.btnHorario)
        val btnEventos = findViewById<Button>(R.id.btnEventos)

        btnHorario.setOnClickListener {
            startActivity(Intent(this, MainActivityHorario::class.java))
        }

        btnEventos.setOnClickListener {
            startActivity(Intent(this, EventListActivity::class.java))
        }
    }
}