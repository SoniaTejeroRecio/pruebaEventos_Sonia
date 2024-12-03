package com.example.prueba_sonia.AppHorario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_sonia.R

class MainActivityHorario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_horario)

        val addClassButton = findViewById<Button>(R.id.btnAddClass)
        val viewScheduleButton = findViewById<Button>(R.id.btnViewSchedule)
        val whatNowButton = findViewById<Button>(R.id.btnWhatNow)

        addClassButton.setOnClickListener {
            startActivity(Intent(this, AddClassActivity::class.java))
        }

        viewScheduleButton.setOnClickListener {
            startActivity(Intent(this, ViewScheduleActivity::class.java))
        }

        whatNowButton.setOnClickListener {
            startActivity(Intent(this, WhatNowActivity::class.java))
        }
    }
}