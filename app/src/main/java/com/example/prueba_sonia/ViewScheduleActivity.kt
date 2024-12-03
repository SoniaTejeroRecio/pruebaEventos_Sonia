package com.example.prueba_sonia

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ViewScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_schedule)

        val scheduleListView = findViewById<ListView>(R.id.listViewSchedule)


        val schedule = listOf(
            "Lunes - 10:00 - Matemáticas",
            "Martes - 12:00 - Historia",
            "Miércoles - 15:00 - Programación"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, schedule)
        scheduleListView.adapter = adapter
    }
}
