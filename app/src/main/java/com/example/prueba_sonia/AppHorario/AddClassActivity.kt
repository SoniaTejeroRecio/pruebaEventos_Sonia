package com.example.prueba_sonia.AppHorario

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_sonia.R
import java.util.Calendar

class AddClassActivity : AppCompatActivity() {
    private lateinit var selectedDate: String
    private lateinit var selectedTime: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_class)

        val subjectInput = findViewById<EditText>(R.id.inputSubject)
        val selectDateButton = findViewById<Button>(R.id.btnSelectDate)
        val selectTimeButton = findViewById<Button>(R.id.btnSelectTime)
        val addButton = findViewById<Button>(R.id.btnAdd)
        val cancelButton = findViewById<Button>(R.id.btnCancel)

        selectDateButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                selectDateButton.text = selectedDate
            }, year, month, day).show()
        }

        selectTimeButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                selectedTime = "$selectedHour:$selectedMinute"
                selectTimeButton.text = selectedTime
            }, hour, minute, true).show()
        }

        addButton.setOnClickListener {
            val subject = subjectInput.text?.toString() ?: ""

            if (subject.isNotEmpty() && ::selectedDate.isInitialized && ::selectedTime.isInitialized) {
                Toast.makeText(this, getString(R.string.class_added), Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, getString(R.string.fill_fields), Toast.LENGTH_SHORT).show()
            }
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }
}