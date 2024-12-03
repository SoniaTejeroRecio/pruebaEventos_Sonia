package com.example.prueba_sonia

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_class)

        val daySpinner = findViewById<Spinner>(R.id.spinnerDay)
        val hourInput = findViewById<EditText>(R.id.inputHour)
        val subjectInput = findViewById<EditText>(R.id.inputSubject)
        val addButton = findViewById<Button>(R.id.btnAdd)
        val cancelButton = findViewById<Button>(R.id.btnCancel)

        addButton.setOnClickListener {
            val day = daySpinner.selectedItem?.toString() ?: ""
            val hour = hourInput.text?.toString() ?: ""
            val subject = subjectInput.text?.toString() ?: ""

            if (day.isNotEmpty() && hour.isNotEmpty() && subject.isNotEmpty()) {
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