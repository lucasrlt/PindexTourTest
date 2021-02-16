package com.pindex.main.ui.blocks

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import com.pindex.main.R
import com.pindex.main.utils.MediaLoader

/**
 * Custom View for the Borderless Image block.
 */
class BorderlessImageBlock @JvmOverloads constructor(
        imagePath: String?,
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val imageView: AppCompatImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.pindex_block_borderless_image, this, true)

        imageView = findViewById(R.id.pindex_block_borderless_image)

        // Load the image from Firebase
        imagePath?.let {
            MediaLoader.loadImageFromFirebase(imagePath, imageView)
        }
    }
}
