package com.example.test

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.telephony.PhoneNumberUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.test.databinding.ActivityImplicitBinding

class ImplicitActivity : AppCompatActivity() {
  private lateinit var binding: ActivityImplicitBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityImplicitBinding.inflate(layoutInflater)
    setContentView(binding.root)
    binding.web.setOnClickListener {
      val intent = Intent(Intent.ACTION_VIEW)
      intent.data = Uri.parse("https://www.instagram.com/vishalgoswami7714/")
      startActivity(intent)
    }
    binding.camera.setOnClickListener {
      val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
      startActivity(intent)
    }

    binding.call.setOnClickListener {
      if (
        ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) !=
          PackageManager.PERMISSION_GRANTED
      ) {
        Toast.makeText(this, "Please grant Dial permission", Toast.LENGTH_SHORT).show()
        requestPermission()
      } else {

        // Changed from "tel :$number" to "tel:$number", this solved the first error.
        /*this made an another error the dialer was taking the given number input as (992) 436-2625
        when tested on emulator, might work well in the physical device.*/

        //        var intent = Intent(Intent.ACTION_DIAL)
        //        var number = "9924362625"
        //        intent.setData(
        //          Uri.parse("tel:$number") //
        //        )

        val intent = Intent(Intent.ACTION_DIAL)
        var number = "9924362625"
        number = PhoneNumberUtils.formatNumber(number, "IN") // Respected Country code
        intent.data = Uri.parse("tel:$number")
        this.startActivity(intent)
      }
    }
  }

  private fun requestPermission() {
    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1)
  }
}
