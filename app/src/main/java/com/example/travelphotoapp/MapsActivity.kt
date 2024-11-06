package com.example.travelphotoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.travelphotoapp.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val placeName = intent.getStringExtra("placeName")
        val locations = intent.getSerializableExtra("locations") as Array<LocationData>
        val index = intent.getIntExtra("index", 0)
        val latitude = locations[index].latitude
        val longitude = locations[index].longitude

        // Added a marker and move the camera
        val placeLocation = LatLng(latitude, longitude)
        mMap.addMarker(MarkerOptions().position(placeLocation).title(placeName))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(placeLocation, 15f))
    }
}