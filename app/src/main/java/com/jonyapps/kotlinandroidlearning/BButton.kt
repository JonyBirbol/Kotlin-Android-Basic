package com.jonyapps.kotlinandroidlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.b_button.*

class BButton : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.b_button)

        button1_1.setOnClickListener {
            val intent = Intent(this, BRecyclerViewA::class.java)
            startActivity(intent)
        }
        button1_12.setOnClickListener {
            val intent = Intent(this, BRecyclerViewB::class.java)
            startActivity(intent)
        }
        button1_13.setOnClickListener {
            val intent = Intent(this, BListViewA::class.java)
            startActivity(intent)
        }
        button1_14.setOnClickListener {
            val intent = Intent(this, BListViewB::class.java)
            startActivity(intent)
        }
        button1_15.setOnClickListener {
            val intent = Intent(this, BListViewC::class.java)
            startActivity(intent)
        }
    }
}
