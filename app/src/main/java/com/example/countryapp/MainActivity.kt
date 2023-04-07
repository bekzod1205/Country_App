package com.example.countryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, CountryFragment())
            .commit()
    }
}