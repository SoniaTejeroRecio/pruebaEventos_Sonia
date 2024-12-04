package com.example.prueba_sonia.AppFarmacia


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba_sonia.R
import org.json.JSONObject

class MainActivityFarmacia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_farmacia)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewFarmacias)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val jsonString = assets.open("farmacias.json").bufferedReader().use { it.readText() }
        val farmacias = parseFarmacias(jsonString)


        recyclerView.adapter = FarmaciaAdapter(farmacias) { farmacia ->
            val intent = Intent(this, MapActivity::class.java)
            intent.putExtra("nombre", farmacia.nombre)
            intent.putExtra("latitud", farmacia.coordenadas[1])
            intent.putExtra("longitud", farmacia.coordenadas[0])
            startActivity(intent)
        }
    }

    private fun parseFarmacias(jsonString: String): List<Farmacia> {
        val farmacias = mutableListOf<Farmacia>()
        val jsonObject = JSONObject(jsonString)
        val features = jsonObject.getJSONArray("features")

        for (i in 0 until features.length()) {
            val feature = features.getJSONObject(i)
            val properties = feature.getJSONObject("properties")
            val geometry = feature.getJSONObject("geometry")

            val nombre = properties.getString("title")
            val description = properties.getString("description")
            val telefonoRegex = "Teléfono: ([0-9\\s]+)".toRegex()
            val telefono = telefonoRegex.find(description)?.groups?.get(1)?.value ?: "No disponible"
            val coordenadas = geometry.getJSONArray("coordinates")
            val coords = listOf(coordenadas.getDouble(0), coordenadas.getDouble(1))

            farmacias.add(Farmacia(nombre, telefono, coords))
        }

        return farmacias
    }
}

