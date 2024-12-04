package com.example.prueba_sonia.AppFarmacia
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_sonia.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val nombre = intent.getStringExtra("nombre") ?: "Ubicación"
        val latitud = intent.getDoubleExtra("latitud", 0.0)
        val longitud = intent.getDoubleExtra("longitud", 0.0)

        val ubicacion = LatLng(latitud, longitud)
        map.addMarker(MarkerOptions().position(ubicacion).title(nombre))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 15f))
    }
}
