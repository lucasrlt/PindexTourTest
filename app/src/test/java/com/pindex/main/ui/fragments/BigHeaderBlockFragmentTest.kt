package com.pindex.main.ui.fragments

import      androidx.appcompat.widget.AppCompatTextView
import com.pindex.main.R
import com.pindex.main.ui.fragments.blocks.BigHeaderBlockFragment
import junit.framework.TestCase.assertEquals
import org.junit.Test

class BigHeaderBlockFragmentTest {

    @Test
    fun bigHeaderBlockFragmentIsCreated() {
        val block = BigHeaderBlockFragment()

        val textView = block.view?.findViewById<AppCompatTextView>(R.id.pindex_block_big_header)
        assertEquals(textView?.text, null)
    }

}