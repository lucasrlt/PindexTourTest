package com.pindex.main.ui.blocks

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.pindex.main.R

/**
 * Custom TextView for the Section Title block.
 */
class SectionTitleBlock @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle) {

    /**
     * Apply the Section Title block styles to this TextView.
     */
    init {
        // Font family
        typeface = ResourcesCompat.getFont(context, R.font.montserrat_bold)

        // Font size
        textSize = 30f

        // Font color
        setTextColor(ResourcesCompat.getColor(resources, R.color.pindex_lead, null))
    }

}
