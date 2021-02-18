package com.pindex.main.ui.fragments

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pindex.main.R
import com.pindex.main.ui.fragments.blocks.AudioBlockFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AudioBlockFragmentInstrumentedTest {

    @Test
    fun theAudioBlockShouldDisplay() {
        val imagePath = "l"
        val name = "303 Acid Bass"
        val audioPath = "l"

        val fragmentArgs = bundleOf(
            "imagePath" to imagePath,
            "name" to name,
            "audioPath" to audioPath
        )
        launchFragmentInContainer<AudioBlockFragment>(fragmentArgs)

        Espresso.onView(ViewMatchers.withId(R.id.pindex_block_audio_button))
            .check(ViewAssertions.matches(ViewMatchers.withText(name)))
    }

}