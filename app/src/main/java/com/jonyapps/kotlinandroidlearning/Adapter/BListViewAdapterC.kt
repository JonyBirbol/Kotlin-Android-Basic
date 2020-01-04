package com.jonyapps.kotlinandroidlearning.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.jonyapps.kotlinandroidlearning.Model.BListViewModelC
import com.jonyapps.kotlinandroidlearning.R
import java.util.ArrayList


class BListViewAdapterC (private val context: Context, private val BListViewModelCArrayList: ArrayList<BListViewModelC>) : BaseAdapter() {

    //b_list_view_model_c.xml need to create

    override fun getViewTypeCount(): Int {
        return count
    }

    override fun getItemViewType(position: Int): Int {

        return position
    }

    override fun getCount(): Int {
        return BListViewModelCArrayList.size
    }

    override fun getItem(position: Int): Any {
        return BListViewModelCArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder

        if (convertView == null) {
            holder = ViewHolder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.b_list_view_model_c, null, true)

            holder.tvname = convertView!!.findViewById(R.id.name) as TextView
            holder.iv = convertView.findViewById(R.id.imgView) as ImageView

            convertView.tag = holder


        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = convertView.tag as ViewHolder
        }

        holder.tvname!!.setText(BListViewModelCArrayList[position].getNames())
        holder.iv!!.setImageResource(BListViewModelCArrayList[position].getImage_drawables())

        //OnClick Action
        holder.tvname!!.setOnClickListener { v: View ->
            Toast.makeText(v.getContext(), "Click detected on item", Toast.LENGTH_SHORT).show();

        }




        return convertView
    }

    private inner class ViewHolder {

        var tvname: TextView? = null
        internal var iv: ImageView? = null

    }

}
