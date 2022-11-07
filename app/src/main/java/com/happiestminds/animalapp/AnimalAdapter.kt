package com.happiestminds.animalapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class AnimalAdapter(
    private val values: List<Animal>
) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.fragment_item,parent,false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = values[position]
        holder.idView.text = animal.name
        when(animal.name.lowercase()){
            "cat"->holder.imageView.setImageResource(R.drawable.cat)
            "parrot"->holder.imageView.setImageResource(R.drawable.parrot)
             "cow"->holder.imageView.setImageResource(R.drawable.cow)
            "rabbit"->holder.imageView.setImageResource(R.drawable.rabbit)
            "zebra"->holder.imageView.setImageResource(R.drawable.zebra)
            "rhinoceros"->holder.imageView.setImageResource(R.drawable.rhinoceros)
            "lion"->holder.imageView.setImageResource(R.drawable.lion)
            "deer"->holder.imageView.setImageResource(R.drawable.deer)
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val imageView: ImageView = view.findViewById(R.id.imageView)

    }

}