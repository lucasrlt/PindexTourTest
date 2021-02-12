package com.pindex.main.ui.blocks

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.pindex.main.R

/**
 * Custom TextView for the Big Header block.
 */
class BigHeaderBlock @JvmOverloads constructor(
        title: String?,
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle) {

    /**
     * Apply the Big Header block styles to this TextView.
     */
    init {
        // Set the text
        text = title

        // Font family
        typeface = ResourcesCompat.getFont(context, R.font.montserrat_bold)

        // Font size
        textSize = 36f

        // Font colour
        setTextColor(ResourcesCompat.getColor(resources, R.color.pindex_lead, null))
    }

}
