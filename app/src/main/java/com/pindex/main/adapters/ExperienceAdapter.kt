package com.pindex.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pindex.main.R
import com.pindex.main.models.ContentDto
import com.pindex.main.models.ExperienceDto

/**
 * An Experience can either be a Pindex Tour or a Pindex Activity/Event.
 */
class ExperienceAdapter : PagingDataAdapter<ExperienceDto, ExperienceAdapter.ViewHolder>(ExperiencesComparator) {

    /**
     * On item click function.
     *
     * Not a good practice to open an activity from a view holder context.
     * An activity should be opened from another activity.
     */
    var onItemClick: ((ExperienceDto) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_experience, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val experience: ExperienceDto? = getItem(position)
        experience?.let { holder.bind(it) }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var experienceType = view.findViewById<TextView>(R.id.experience_type)
        private var experienceTitle = view.findViewById<TextView>(R.id.experience_title)
        private var experienceDescription = view.findViewById<TextView>(R.id.experience_description)

        /**
         * Bind the given [experience] data to the view.
         */
        fun bind(experience: ExperienceDto) {
            // Experience type: activity, event or tour
            experienceType.text = "Pindex ${experience.type?.capitalize()}"

            var content: ContentDto? = experience.content?.get(0)
            // Experience title
            experienceTitle.text = content?.title
            // Experience short description
            experienceDescription.text = content?.shortDescription
        }

        /**
         * Call the onItemClick function when an item is clicked.
         */
        init {
            view.setOnClickListener {
                val experience: ExperienceDto? = getItem(absoluteAdapterPosition)
                onItemClick?.invoke(experience!!)
            }
        }

    }

    companion object {

        private val ExperiencesComparator = object : DiffUtil.ItemCallback<ExperienceDto>() {

            override fun areItemsTheSame(oldItem: ExperienceDto, newItem: ExperienceDto): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ExperienceDto, newItem: ExperienceDto): Boolean {
                return oldItem == newItem
            }

        }

    }

}
