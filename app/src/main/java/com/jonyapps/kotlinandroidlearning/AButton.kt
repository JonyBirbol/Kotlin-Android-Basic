package com.jonyapps.kotlinandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.a_button.*

class AButton : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_button)

//***Toolbar*** - a
        //style:  <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = "Button 1"
        actionBar.setDisplayHomeAsUpEnabled(true) //Note: Enables back Arrow Icon


//***Toast***
        //Toast will be shown when button is clicked
        button1_1.setOnClickListener {
            val text = "Showing toast!"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }

    }

//***Toolbar*** - b
//Note: Going to back activity when Toolbar back Button is pressed
    override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
       }
      }

//***Toolbar*** - Other Way
// Link: https://developer.android.com/training/appbar/up-action