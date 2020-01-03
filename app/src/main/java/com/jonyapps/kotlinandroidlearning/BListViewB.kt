package com.jonyapps.kotlinandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.b_list_view_b.*

class BListViewB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.b_list_view_b)

//List View** Simple ListView 1
        //1. For Simple List View write "string-array" (see in the Values folder >string.xml>  string-array name="Colors")
        //2. Add ListView in the b_list_view_b.xml files
        //3. add  android:entries="@array/Colors" lines for showing String as simple ListView


//List View** Simple ListView 2 (adding listSelector and divider)

        //1. add  below lines in "b_list_view_b.xml" for Customization
       // android:listSelector="@android:color/holo_green_dark"
       // android:clickable="true"
        //android:divider="@color/colorPrimary"
       // android:dividerHeight="2dp"


//List View** Simple ListView 3
        // 1. Create b_list_selector.xml file in the Drawable folder
        //2. android:listSelector="@drawable/list_selector" (replace in the line at "b_list_view_b.xml" instead of  android:listSelector="@android:color/holo_green_dark" )


//Adding Click Action on the Items

        var colorArrays = resources.getStringArray(R.array.Colors)
        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, colorArrays)

        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { adapterView, view, position: Int, id: Long ->

            Toast.makeText(applicationContext,colorArrays[position], Toast.LENGTH_SHORT).show()
        }
    }
    }
