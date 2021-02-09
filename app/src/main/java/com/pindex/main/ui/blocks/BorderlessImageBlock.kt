package com.pindex.main.ui.blocks

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.pindex.main.utils.Converter

/**
 * Custom ImageView for the Borderless Image block.
 */
class BorderlessImageBlock @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : AppCompatImageView(context, attrs, defStyle) {

    /**
     * Apply Borderless Image block styles to this ImageView.
     */
    init {
        // Adjust the image bounds to preserve the aspect ratio
        adjustViewBounds = true

        // Image maximum height [dp]
        maxHeight = Converter.dpToPixels(500, context)
    }
}
