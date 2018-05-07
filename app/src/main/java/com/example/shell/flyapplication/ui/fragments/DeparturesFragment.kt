package com.example.shell.flyapplication.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shell.flyapplication.R
import com.example.shell.flyapplication.models.Flight
import com.example.shell.flyapplication.ui.adapters.FlightAdapter
import com.example.shell.flyapplication.ui.adapters.FlightListener
import com.example.shell.flyapplication.utils.showMessage
import kotlinx.android.synthetic.main.fragment_departures.*
import kotlinx.android.synthetic.main.fragment_departures.view.*

class DeparturesFragment : Fragment() {

    private val flightList: ArrayList<Flight> by lazy { getFlights() } // Si esta variable no se llama, las funciones dentro de lazy jamás se ejecutan
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: FlightAdapter
    private val layoutManager by lazy { LinearLayoutManager(context) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity?.setTitle(R.string.departure_title)

        val rootView = inflater.inflate(R.layout.fragment_departures, container, false)

        recycler = rootView.recFlights as RecyclerView
        setRecyclerView()

        return rootView
    }

    private fun setRecyclerView() {
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager
        adapter = FlightAdapter(flightList, object: FlightListener {

            override fun onClick(flight: Flight, position: Int) {
                departureContainer.showMessage("Let's go to ${flight.city}!")
            }

            override fun onDelete(flight: Flight, position: Int) {
                flightList.remove(flight)
                adapter.notifyItemRemoved(position)
                departureContainer.showMessage("${flight.city} has been removed!")
            }

        })

        recycler.adapter = adapter
    }

    private fun getFlights() : ArrayList<Flight> {
        return object : ArrayList<Flight>() {
            init {
                add(Flight(1, "Seattle", R.drawable.seattle))
                add(Flight(2, "New York", R.drawable.new_york))
                add(Flight(3, "London", R.drawable.london))
                add(Flight(4, "Mexico", R.drawable.mexico))
                add(Flight(5, "Venice", R.drawable.venice))
                add(Flight(6, "Athens", R.drawable.athens))
                add(Flight(7, "Toronto", R.drawable.toronto))
                add(Flight(8, "Dublin", R.drawable.dublin))
                add(Flight(9, "Caribbean", R.drawable.caribbean))
            }
        }
    }
}
