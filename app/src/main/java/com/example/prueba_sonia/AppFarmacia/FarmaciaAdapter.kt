package com.example.prueba_sonia.AppFarmacia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba_sonia.R

class FarmaciaAdapter(
    private val farmacias: List<Farmacia>,
    private val onClick: (Farmacia) -> Unit
) : RecyclerView.Adapter<FarmaciaAdapter.FarmaciaViewHolder>() {

    class FarmaciaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreTextView: TextView = view.findViewById(R.id.textNombre)
        val telefonoTextView: TextView = view.findViewById(R.id.textTelefono)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmaciaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_farmacia, parent, false)
        return FarmaciaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FarmaciaViewHolder, position: Int) {
        val farmacia = farmacias[position]
        holder.nombreTextView.text = farmacia.nombre
        holder.telefonoTextView.text = farmacia.telefono
        holder.itemView.setOnClickListener { onClick(farmacia) }
    }

    override fun getItemCount() = farmacias.size
}