package com.pindex.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pindex.main.R

class ItemAdapter(val itemList: Array<String>) :
        RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // On item click function
    // Not a good practice to open an activity from a view holder context
    // Handled in the HomeActivity
    var onItemClick: ((String) -> Unit)? = null

    // Describes an item view and its place within the RecyclerView
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemNameTextView: TextView = itemView.findViewById(R.id.item_name)

        fun bind(word: String) {
            itemNameTextView.text = word
        }

        // Call the onItemClick function when an item is clicked
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(itemList[adapterPosition])
            }
        }
    }

    // Returns a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_item, parent, false)

        return ItemViewHolder(view)
    }

    // Returns size of data list
    override fun getItemCount(): Int {
        return itemList.size
    }

    // Displays data at a certain position
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

}