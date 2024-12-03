package com.example.prueba_sonia

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class WhatNowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_now)

        val currentTimeTextView = findViewById<TextView>(R.id.txtCurrentTime)
        val currentClassTextView = findViewById<TextView>(R.id.txtCurrentClass)

        val currentDateTime = SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm", Locale.getDefault()).format(Date())
        currentTimeTextView.text = currentDateTime


        val currentClass = "Estás en clase de Matemáticas"
        currentClassTextView.text = currentClass
    }
}
