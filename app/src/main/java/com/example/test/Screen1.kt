package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test.databinding.ActivityScreen1Binding
import java.security.Key

class Screen1 : AppCompatActivity() {
    lateinit var binding: ActivityScreen1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var message = intent.getStringExtra("Key").toString()

        binding.finish.text = "Thanks ${message} to Visit this application"

    }
}