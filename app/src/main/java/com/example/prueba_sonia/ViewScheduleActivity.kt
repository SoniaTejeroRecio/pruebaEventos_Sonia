package com.example.prueba_sonia

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class ViewScheduleActivity : AppCompatActivity() {

    private lateinit var spinnerDay: Spinner
    private lateinit var listViewSubjects: ListView

    private val schedule = mapOf(
        //Esto son ejmeplos, luego los modificaré
        "Lunes" to listOf("Matemáticas", "Historia", "Biología"),
        "Martes" to listOf("Física", "Química", "Literatura"),
        "Miércoles" to listOf("Geografía", "Educación Física", "Arte"),
        "Jueves" to listOf("Informática", "Música", "Economía"),
        "Viernes" to listOf("Filosofía", "Inglés", "Ciencias Sociales")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_schedule)

        spinnerDay = findViewById(R.id.spinnerDay)
        listViewSubjects = findViewById(R.id.listViewSubjects)

        val daysArray = resources.getStringArray(R.array.days_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, daysArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDay.adapter = adapter

        spinnerDay.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedDay = parent.getItemAtPosition(position).toString()
                val subjects = schedule[selectedDay] ?: emptyList()
                val subjectsAdapter = ArrayAdapter(this@ViewScheduleActivity, android.R.layout.simple_list_item_1, subjects)
                listViewSubjects.adapter = subjectsAdapter
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }
}