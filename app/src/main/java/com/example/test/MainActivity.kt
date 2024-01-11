package com.example.test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.exBtn.setOnClickListener {
      intent = Intent(this, ExplicitActivity::class.java)
      startActivity(intent)
      finish()
    }

    binding.imBtn.setOnClickListener {
      var intent = Intent(this, ImplicitActivity::class.java)
      startActivity(intent)
      finish()
    }
  }
}
