package com.example.prueba_sonia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_sonia.AppEventos.EventListActivity
import com.example.prueba_sonia.AppFarmacia.MainActivityFarmacia
import com.example.prueba_sonia.AppHorario.MainActivityHorario
import com.example.prueba_sonia.R
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHorario = findViewById<Button>(R.id.btnHorario)
        val btnEventos = findViewById<Button>(R.id.btnEventos)
        val btnFarmacias = findViewById<Button>(R.id.btnFarmacias)

        btnHorario.setOnClickListener {
            startActivity(Intent(this, MainActivityHorario::class.java))
        }

        btnEventos.setOnClickListener {
            startActivity(Intent(this, EventListActivity::class.java))
        }

        btnFarmacias.setOnClickListener {
            val intent = Intent(this, MainActivityFarmacia::class.java)
            startActivity(intent)

        }


    }

    }

    private fun extraerTelefono(description: String): String? {
        val regex = "\\d{9}".toRegex()
        return regex.find(description)?.value
        }

