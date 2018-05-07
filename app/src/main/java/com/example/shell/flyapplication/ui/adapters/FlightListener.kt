package com.example.shell.flyapplication.ui.adapters

import com.example.shell.flyapplication.models.Flight
import java.text.FieldPosition

interface FlightListener {

    fun onClick(flight: Flight, position: Int)
    fun onDelete(flight: Flight, position: Int)
}