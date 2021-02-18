package com.pindex.main.ui.fragments

import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import com.pindex.main.R
import com.pindex.main.ui.fragments.blocks.AudioBlockFragment
import junit.framework.TestCase.assertEquals
import org.junit.Test

class AudioBlockFragmentTest {

    @Test
    fun audioBlockFragmentIsCreated() {
        val block = AudioBlockFragment()

        val imageView = block.view?.findViewById<AppCompatImageView>(R.id.pindex_block_audio_image)
        assertEquals(imageView?.background, null)

        val buttonView = block.view?.findViewById<AppCompatButton>(R.id.pindex_block_audio_button)
        assertEquals(buttonView?.text, null)
    }

}