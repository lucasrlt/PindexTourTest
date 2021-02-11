package com.pindex.main.utils

import android.content.Context
import android.util.Log
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

    /** Load the image at the given [imageURL] and add it to the given [view].
     */
    fun loadImageFromURL(imageURL: String, view: AppCompatImageView) {
        Glide.with(view)
                .load(imageURL)
                .centerCrop()
                .into(view)
    }

    /**
     * Load the image from Firebase associated to the given [imagePath] and
     * add it to the given [view].
     */
    fun loadImageFromFirebase(imagePath: String, view: AppCompatImageView) {
        // Get the image storage path from Firebase
        val imageRef: StorageReference = Firebase.storage.reference.child(imagePath)

        imageRef.downloadUrl.addOnSuccessListener { Uri ->

            // The image URL from Firebase
            val imageURL: String = Uri.toString()

            loadImageFromURL(imageURL, view)
        }
    }

}
