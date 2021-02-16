package com.pindex.main.ui.blocks

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.pindex.main.R

/**
 * Custom View for the Section Title block.
 */
class SectionTitleBlock @JvmOverloads constructor(
        title: String?,
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val textView: AppCompatTextView

    init {
        LayoutInflater.from(context).inflate(R.layout.pindex_block_section_title, this, true)

        textView = findViewById(R.id.pindex_block_section_title)

        // Set the text
        textView.text = title
    }

}
