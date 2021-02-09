package com.pindex.main.ui.blocks

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
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
        adjustViewBounds = true

        // dp to pixels formula
        val scale: Float = context.resources.displayMetrics.density
        val pixels: Int = (500 * scale + 0.5f).toInt()
        maxHeight = pixels
    }

    fun loadImage(imagePath: String) {
        val imageRef: StorageReference = Firebase.storage.reference.child(imagePath)

        imageRef.downloadUrl.addOnSuccessListener { Uri ->

            val imageURL: String = Uri.toString()

            Glide.with(this)
                    .load(imageURL)
                    .override(1920, 1080)
                    .centerCrop()
                    .into(this)
        }
    }
}
