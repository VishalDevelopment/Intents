package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.exBtn.setOnClickListener { 
            intent = Intent(this,Explicit_Activity::class.java)
            startActivity(intent)
            finish()
        }
        
        binding.imBtn.setOnClickListener {
            var intent = Intent(this, Implicit_Activity::class.java)
            startActivity(intent)
            finish()
        }



    }
}