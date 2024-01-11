package com.example.test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityExplicitBinding
import com.example.test.databinding.ActivityScreen1Binding

class ExplicitActivity : AppCompatActivity() {
  lateinit var binding: ActivityExplicitBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityExplicitBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.go.setOnClickListener {
      val name = binding.editTxt.text.toString()
      var intent = Intent(this,Screen1::class.java)
      intent.putExtra("Key",name)
      startActivity(intent)
    }

  }
}
