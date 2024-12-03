package com.example.prueba_sonia.AppEventos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import com.example.prueba_sonia.R

class EventListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var eventAdapter: EventAdapter
    private val eventList = mutableListOf<Event>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)

        recyclerView = findViewById(R.id.recyclerViewEvents)
        val btnAddEvent = findViewById<Button>(R.id.btnAddEvent)


        eventAdapter = EventAdapter(eventList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = eventAdapter


        eventList.add(Event("Evento 1", "Descripción 1", "25,45€"))
        eventList.add(Event("Evento 2", "Descripción 2", "10€"))
        eventList.add(Event("Evento 3", "Descripción 3", "300€"))
        eventList.add(Event("Evento 4", "Descripción 4", "Gratis"))


        eventAdapter.notifyDataSetChanged()


        btnAddEvent.setOnClickListener {
            val intent = Intent(this, RegisterEventActivity::class.java)
            startActivity(intent)
        }
    }
}
