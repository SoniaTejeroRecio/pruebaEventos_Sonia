package com.example.prueba_sonia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
