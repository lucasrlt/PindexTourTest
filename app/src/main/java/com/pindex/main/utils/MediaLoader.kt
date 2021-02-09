package com.pindex.main.utils

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

/**
 * Singleton that provides functions to load media content
 * into views.
 */
object MediaLoader {

    /**
     * Load the image from the given [imagePath] and add it to the given [view].
     */
    fun loadImage(imagePath: String, view: AppCompatImageView) {
        // Get the image storage path from Firebase
        val imageRef: StorageReference = Firebase.storage.reference.child(imagePath)

        imageRef.downloadUrl.addOnSuccessListener { Uri ->

            val imageURL: String = Uri.toString()

            // Load the image and add it to the view
            Glide.with(view)
                    .load(imageURL)
                    .centerCrop()
                    .into(view)
        }
    }

}
