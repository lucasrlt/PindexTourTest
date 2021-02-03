package com.pindex.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pindex.main.R

class ItemAdapter(val itemList: Array<String>) :
        RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /**
     * On item click function.
     *
     * Not a good practice to open an activity from a view holder context.
     * The activity is opened from the HomeActivity.
     */
    var onItemClick: ((String) -> Unit)? = null

    /**
     * Describe an item view and its place within the RecyclerView.
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemNameTextView: TextView = itemView.findViewById(R.id.item_name)

        /**
         * Bind the given [word] to the item activity.
         */
        fun bind(word: String) {
            itemNameTextView.text = word
        }

        /**
         * Call the onItemClick function when an item is clicked.
         */
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(itemList[adapterPosition])
            }
        }
    }

    /**
     * Return a new ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_item, parent, false)

        return ItemViewHolder(view)
    }

    /**
     * Return size of data list.
     */
    override fun getItemCount(): Int {
        return itemList.size
    }

    /**
     * Display data at a certain position.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

}