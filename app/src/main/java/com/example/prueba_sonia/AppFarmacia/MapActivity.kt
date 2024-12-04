package com.example.prueba_sonia.AppFarmacia

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_sonia.R

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapImageView = findViewById<ImageView>(R.id.imageViewMap)
        mapImageView.setImageResource(R.drawable.ic_map)
    }
}