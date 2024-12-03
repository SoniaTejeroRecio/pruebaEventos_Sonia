package com.example.prueba_sonia.AppEventos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import com.example.prueba_sonia.AppEventos.EventAdapter
import com.example.prueba_sonia.AppEventos.RegisterEventActivity
import com.example.prueba_sonia.R

data class Event(val name: String, val description: String, val price: String)

class MainActivityEventos : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var eventAdapter: EventAdapter
    private val eventList = mutableListOf<Event>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_eventos)

        recyclerView = findViewById(R.id.recyclerViewEvents)
        val btnAddEvent = findViewById<Button>(R.id.btnAddEvent)


        eventAdapter = EventAdapter(eventList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = eventAdapter


        btnAddEvent.setOnClickListener {
            val intent = Intent(this, RegisterEventActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val name = data?.getStringExtra("name")
            val description = data?.getStringExtra("description")
            val price = data?.getStringExtra("price")
            if (name != null && description != null && price != null) {
                eventList.add(Event(name, description, price))
                eventAdapter.notifyDataSetChanged()
            }
        }
    }
}