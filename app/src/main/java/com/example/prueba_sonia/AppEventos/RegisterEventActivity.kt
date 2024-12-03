package com.example.prueba_sonia.AppEventos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_sonia.R

class RegisterEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_event)

        val inputName = findViewById<EditText>(R.id.inputName)
        val inputDescription = findViewById<EditText>(R.id.inputDescription)
        val inputAddress = findViewById<EditText>(R.id.inputAddress)
        val inputPrice = findViewById<EditText>(R.id.inputPrice)
        val inputDate = findViewById<EditText>(R.id.inputDate)
        val btnSave = findViewById<Button>(R.id.btnSaveEvent)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        btnSave.setOnClickListener {
            val intent = Intent()
            intent.putExtra("name", inputName.text.toString())
            intent.putExtra("description", inputDescription.text.toString())
            intent.putExtra("price", inputPrice.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        btnCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}