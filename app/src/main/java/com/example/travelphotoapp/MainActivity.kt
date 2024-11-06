package com.example.travelphotoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.travelphotoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imagear = intArrayOf(
            R.drawable.national,
            R.drawable.memmorial,
            R.drawable.ahsanmonzil,
            R.drawable.curjonhall
        )
        val namear = arrayOf(
            "National Parliament Building",
            "National Martyrs' Memorial",
            "Ahsan Monzil",
            "Curjon Hall"
        )
        val locations = arrayOf(
            LocationData(23.7319, 90.3844),
            LocationData(23.8103, 90.4125),
            LocationData(23.7330, 90.3944),
            LocationData(23.7285, 90.3869)
        )

        var index = 0
        var count = 0
        val size = imagear.size

        binding.nextBtn.setOnClickListener {
            index++
            if (index == size) {
                index = 0
            }
            binding.picture.setImageResource(imagear[index])
            binding.placeName.text = namear[index]
        }

        binding.previousBtn.setOnClickListener {
            index--
            if (index == -1) {
                index = size - 1
            }

            binding.picture.setImageResource(imagear[index])
            binding.placeName.text = namear[index]
        }
            binding.imageButton3.setOnClickListener {
                val latitude = locations[index].latitude
                val longitude = locations[index].longitude
                val placeName = namear[index]

                // Create a URI for the location
                val gmmIntentUri = Uri.parse("geo:$latitude,$longitude?q=$placeName")

                // Create an intent with the action ACTION_VIEW
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

                // Set the package to Google Maps (optional)
                mapIntent.setPackage("com.google.android.apps.maps")

                // Verify that there is an app to handle the intent
                if (mapIntent.resolveActivity(packageManager) != null) {
                    startActivity(mapIntent)
                } else {
                    // Handle the case where no map app is available
                    Toast.makeText(this, "No map app found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}