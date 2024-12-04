package com.example.prueba_sonia.AppFarmacia

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba_sonia.R

class FarmaciaAdapter(
    private val farmacias: List<Farmacia>,
    private val onClick: (Farmacia) -> Unit
) : RecyclerView.Adapter<FarmaciaAdapter.FarmaciaViewHolder>() {

    class FarmaciaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconImageView: ImageView = view.findViewById(R.id.icon)
        val nombreTextView: TextView = view.findViewById(R.id.textNombre)
        val telefonoTextView: TextView = view.findViewById(R.id.textTelefono)
        val direccionTextView: TextView = view.findViewById(R.id.textDireccion)
        val buttonMap: Button = view.findViewById(R.id.buttonMap)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmaciaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_farmacia, parent, false)
        return FarmaciaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FarmaciaViewHolder, position: Int) {
        val farmacia = farmacias[position]
        holder.iconImageView.setImageResource(R.drawable.ic_farmacia)
        holder.nombreTextView.text = farmacia.nombre
        holder.telefonoTextView.text = farmacia.telefono
        holder.direccionTextView.text = farmacia.direccion
        holder.itemView.setOnClickListener { onClick(farmacia) }
        holder.buttonMap.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, MapActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = farmacias.size
}