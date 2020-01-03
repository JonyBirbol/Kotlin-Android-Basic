package com.jonyapps.kotlinandroidlearning.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jonyapps.kotlinandroidlearning.R

class BRecyclerViewAdapterB : RecyclerView.Adapter<BRecyclerViewAdapterB.ViewHolder>() {

//Note: Need to create b_cardview_b.xmll (see in the layout Folder)

    private val titles = arrayOf("Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")

    private val details = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item file details", "Item six details",
        "Item seven details", "Item eight details")

    private val images = intArrayOf(
        R.drawable.smartphone,
        R.drawable.smartphone, R.drawable.smartphone,
        R.drawable.smartphone, R.drawable.smartphone,
        R.drawable.smartphone, R.drawable.smartphone,
        R.drawable.smartphone)


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var itemImage: ImageView
            var itemTitle: TextView
            var itemDetail: TextView

            init {
                itemImage = itemView.findViewById(R.id.item_image)
                itemTitle = itemView.findViewById(R.id.item_title)
                itemDetail = itemView.findViewById(R.id.item_detail)

                //not working need to Fix later
                /* itemView.setOnClickListener { v: View ->
                     var position: Int = getAdapterPosition()

                     //Toast.makeText(v.getContext(), "Click detected on item $position", Toast.LENGTH_SHORT).show();
                     Snackbar.make(v, "Click detected on item $position",
                         Snackbar.LENGTH_LONG).setAction("Action", null).show()
                 }*/
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.b_cardview_b, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }
    override fun getItemCount(): Int {
        return titles.size
    }


}