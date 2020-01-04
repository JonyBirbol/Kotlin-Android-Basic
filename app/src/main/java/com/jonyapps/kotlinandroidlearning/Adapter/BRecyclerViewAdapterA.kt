package com.jonyapps.kotlinandroidlearning.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jonyapps.kotlinandroidlearning.Model.BRecyclerViewModelA
import com.jonyapps.kotlinandroidlearning.R
import java.security.AccessController.getContext


class BRecyclerViewAdapterA (val recyclerViewListA: ArrayList<BRecyclerViewModelA>) : RecyclerView.Adapter<BRecyclerViewAdapterA.ViewHolder>() {

//Need to create > b_cardview_a.xmll (See in the layout folder)


    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BRecyclerViewAdapterA.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.b_cardview_a, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: BRecyclerViewAdapterA.ViewHolder, position: Int) {
        holder.bindItems(recyclerViewListA[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return recyclerViewListA.size
    }

    //the class is holding the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(recyclerViewA: BRecyclerViewModelA) {
            val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
            val textViewAddress  = itemView.findViewById(R.id.textViewAddress) as TextView
            textViewName.text = recyclerViewA.name
            textViewAddress.text = recyclerViewA.address


            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Toast.makeText(v.getContext(), "Click detected on item $position", Toast.LENGTH_SHORT).show();

            }
        }
        }
        }



