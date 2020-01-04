package com.jonyapps.kotlinandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.jonyapps.kotlinandroidlearning.Adapter.BListViewAdapterC
import com.jonyapps.kotlinandroidlearning.Model.BListViewModelC

class BListViewC : AppCompatActivity() {

    //Note:
    //Created BListViewAdapterC.kt in the Adapter folder
    //Created b_list_view_model_c.xml for the BListViewAdapterC.kt
    //Created BListViewModelC.kt in the Model Folder
//Credit: https://demonuts.com/android-listview-kotlin/

    private val a = 5
    private val b = 10
    private var lv: ListView? = null
    private var customeAdapter: BListViewAdapterC? = null
    private var imageModelArrayList: ArrayList<BListViewModelC>? = null
    private val myImageList = intArrayOf(R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone)
    private val myImageNameList = arrayOf("Benz", "Bike", "Car", "Carrera", "Ferrari", "Harly", "Lamborghini", "Silver")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.b_list_view_c)

        lv = findViewById(R.id.listView) as ListView

        imageModelArrayList = populateList()
       // Log.d("hjhjh", imageModelArrayList!!.size.toString() + "")
        customeAdapter = BListViewAdapterC(this, imageModelArrayList!!)
        lv!!.adapter = customeAdapter




    }

    private fun populateList(): ArrayList<BListViewModelC> {

        val list = ArrayList<BListViewModelC>()

        for (i in 0..7) {
            val imageModel = BListViewModelC()
            imageModel.setNames(myImageNameList[i])
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)

        }


        return list
    }


}