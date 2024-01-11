package com.example.test

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.test.databinding.ActivityImplicitBinding

class Implicit_Activity : AppCompatActivity() {
    lateinit var binding: ActivityImplicitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImplicitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.web.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.instagram.com/vishalgoswami7714/")
            startActivity(intent)
        }
        binding.camera.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)

        }

        binding.call.setOnClickListener {


            if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Please grant Dial permission", Toast.LENGTH_SHORT).show()
            }
            else{
                var intent = Intent(Intent.ACTION_DIAL)
                var number = "9924362625"
                intent.setData(Uri.parse("tel :$number"))

                this.startActivity(intent)
            }
        }
    }

    fun requestPermission(){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),1)
    }
}