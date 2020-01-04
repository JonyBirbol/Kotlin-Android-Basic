package com.jonyapps.kotlinandroidlearning.Adapter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class CMyBroadcastReceiver: BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {


        val extra = intent?.getStringExtra("My Favorite Color")

        Toast.makeText(context,extra,Toast.LENGTH_LONG).show()


    }
}