package com.pindex.main.ui.fragments

import androidx.appcompat.widget.AppCompatTextView
import com.pindex.main.R
import com.pindex.main.ui.fragments.blocks.TextBlockFragment
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TextBlockFragmentTest {

    @Test
    fun textBlockFragmentIsCreated() {
        val block = TextBlockFragment()

        val textView = block.view?.findViewById<AppCompatTextView>(R.id.pindex_block_text)
        assertEquals(textView?.text, null)
    }

}