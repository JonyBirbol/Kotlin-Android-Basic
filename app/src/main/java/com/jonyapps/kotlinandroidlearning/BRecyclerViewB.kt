package com.jonyapps.kotlinandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jonyapps.kotlinandroidlearning.Adapter.BRecyclerViewAdapterA
import com.jonyapps.kotlinandroidlearning.Adapter.BRecyclerViewAdapterB
import kotlinx.android.synthetic.main.b_recycler_view_b.*

class BRecyclerViewB : AppCompatActivity() {

//Note: Need to create BRecyclerViewAdapterB.kt and b_cardview_b.xmll (see in the Adapter and layout Folder)
//Credit: https://www.techotopia.com/index.php/A_Kotlin_Android_RecyclerView_and_CardView_Tutorial

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<BRecyclerViewAdapterB.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.b_recycler_view_b)


        layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager

        adapter = BRecyclerViewAdapterB()
        recycler_view.adapter = adapter

    }
}