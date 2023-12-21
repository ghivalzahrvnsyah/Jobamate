package com.example.jobamate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LandingPageAdapter(private val title : List<String>,
                         private val description : List<String>,
                         private val image : List<Int>
    ): RecyclerView.Adapter<LandingPageAdapter.LandingPageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandingPageViewHolder {
        return LandingPageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_landing_page,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LandingPageViewHolder, position: Int) {
        holder.textTitle.text = title[position]
        holder.textDescription.text = description[position]
        holder.itemImage.setImageResource(image[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }

    inner class LandingPageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

         val textTitle = view.findViewById<TextView>(R.id.title_landing_page)
         val textDescription = view.findViewById<TextView>(R.id.desc_landing_page)
         val itemImage = view.findViewById<ImageView>(R.id.item_landing_page)


    }

}