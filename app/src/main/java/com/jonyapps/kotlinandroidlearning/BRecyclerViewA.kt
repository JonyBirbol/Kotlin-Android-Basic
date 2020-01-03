package com.jonyapps.kotlinandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jonyapps.kotlinandroidlearning.Adapter.BRecyclerViewAdapterA
import com.jonyapps.kotlinandroidlearning.Model.BRecyclerViewModelA

class BRecyclerViewA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.b_recycler_view_a)

//Note: Need to create > BRecyclerViewModelA.kt (see in the Model folder)
//Need to create >BRecyclerViewAdapterA.kt and  b_cardview_a.xmll (See in the Adapter and layout folder)

        //getting recyclerview from xml
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        //crating an arraylist to store users using the data class user
        val users = ArrayList<BRecyclerViewModelA>()

        //adding some dummy data to the list
        users.add(BRecyclerViewModelA("AAAAAAAAAAAAA", "bbbbb bbbbb"))
        users.add(BRecyclerViewModelA("BBBBBB", "cccccccccc ccccc"))
        users.add(BRecyclerViewModelA("CCCCCCCC", "dddddd dddddddd"))
        users.add(BRecyclerViewModelA("DDDDDDDD", "aaaaa aaaaaaaaa"))

        //creating our adapter
        val adapter = BRecyclerViewAdapterA(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }
}