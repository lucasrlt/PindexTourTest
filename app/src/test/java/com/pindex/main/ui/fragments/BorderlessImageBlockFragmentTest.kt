package com.pindex.main.ui.fragments

import androidx.appcompat.widget.AppCompatImageView
import com.pindex.main.R
import com.pindex.main.ui.fragments.blocks.BorderlessImageBlockFragment
import junit.framework.TestCase.assertEquals
import org.junit.Test

class BorderlessImageBlockFragmentTest {

    @Test
    fun borderlessImageBlockFragmentIsCreated() {
        val block = BorderlessImageBlockFragment()

        val imageView = block.view?.findViewById<AppCompatImageView>(R.id.pindex_block_borderless_image)
        assertEquals(imageView?.background, null)
    }

}