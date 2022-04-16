package com.example.fooddelivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter(val dataSet: List<Restaurant>) : RecyclerView.Adapter<adapter.itemViewHolder>(){

    class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        companion object{
            fun from(parent: ViewGroup): itemViewHolder{
                var layoutInflater= LayoutInflater.from(parent.context)
                var view =layoutInflater.inflate(R.layout.itemview,parent,false)
                return itemViewHolder(view)
            }
        }
        fun bindData(restaurant: Restaurant)
        {
            val name=itemView.findViewById<TextView>(R.id.iv_name)
            val descrip=itemView.findViewById<TextView>(R.id.iv_description)
            val img=itemView.findViewById<ImageView>(R.id.iv_img)
            name.text=restaurant.name
            descrip.text=restaurant.address
            img.setImageResource(restaurant.Img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        return itemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val restaurant=dataSet[position]
        holder.bindData(restaurant)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}