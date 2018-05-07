package com.example.shell.flyapplication.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.shell.flyapplication.R
import com.example.shell.flyapplication.models.Flight
import com.example.shell.flyapplication.utils.inflate
import com.example.shell.flyapplication.utils.loadByResource
import kotlinx.android.synthetic.main.item_flight.view.*

class FlightAdapter(private val flights: List<Flight>, private val listener: FlightListener): RecyclerView.Adapter<FlightAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(parent.inflate(R.layout.item_flight))

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(flights[position], listener)

    override fun getItemCount()
            = flights.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(flight: Flight, listener: FlightListener) = with(itemView) {
            txtCityName.text = flight.city
            imgBackground.loadByResource(flight.imageResource)

            // Click events
            setOnClickListener { listener.onClick(flight, adapterPosition) }
            btnDelete.setOnClickListener { listener.onDelete(flight, adapterPosition) }
        }
    }
}