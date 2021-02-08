package com.pindex.main.ui.blocks

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

class BorderlessImageBlock @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : AppCompatImageView(context, attrs, defStyle) {

    init {

    }

    fun loadImage(imagePath: String) {
        val imageRef: StorageReference = Firebase.storage.reference.child(imagePath)

        imageRef.downloadUrl.addOnSuccessListener { Uri ->

            val imageURL: String = Uri.toString()

            Glide.with(this)
                    .load(imageURL)
                    .into(this)

        }
    }
}
