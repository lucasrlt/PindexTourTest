package com.pindex.main.ui.blocks

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.pindex.main.R

/**
 * Custom TextView for the Text block.
 */
class TextBlock @JvmOverloads constructor(
        content: String?,
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle) {

    /**
     * Apply the Text block styles to this TextView.
     */
    init {
        // Set the text
        text = content

        // Font family
        typeface = ResourcesCompat.getFont(context, R.font.montserrat_semibold)

        // Font size
        textSize = 17f

        // Font colour
        setTextColor(ResourcesCompat.getColor(resources, R.color.pindex_text, null))
    }

}
