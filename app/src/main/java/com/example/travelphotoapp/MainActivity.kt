package com.example.travelphotoapp

import android.os.Bundle
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

        val imagear = intArrayOf( R.drawable.national,R.drawable.memmorial,R.drawable.ahsanmonzil,R.drawable.curjonhall)
        val namear = arrayOf("National Parliament Building","National Memorial","Ahsan Monzil","Curjon Hall")

        var index = 0
        var count = 0
        val size = imagear.size

        binding.nextBtn.setOnClickListener {
            index++
            if (index == size) {
                index = 0
            }
            binding.picture.setImageResource(imagear[index])
            binding.placeName.text=namear[index]
        }

        binding.previousBtn.setOnClickListener {
            index--
            if (index == -1) {
                index = size - 1
            }

            binding.picture.setImageResource(imagear[index])
            binding.placeName.text = namear[index]
        }
    }
}