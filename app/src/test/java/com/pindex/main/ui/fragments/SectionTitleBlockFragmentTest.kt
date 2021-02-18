package com.pindex.main.ui.fragments

import androidx.appcompat.widget.AppCompatTextView
import com.pindex.main.R
import com.pindex.main.ui.fragments.blocks.SectionTitleBlockFragment
import junit.framework.TestCase.assertEquals
import org.junit.Test

class SectionTitleBlockFragmentTest {

    @Test
    fun sectionTitleBlockFragmentIsCreated() {
        val block = SectionTitleBlockFragment()

        val textView = block.view?.findViewById<AppCompatTextView>(R.id.pindex_block_section_title)
        assertEquals(textView?.text, null)
    }

}