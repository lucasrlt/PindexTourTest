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
    fun audioBlockShouldDisplayItsAudioName() {
        val name = "303 Acid Bass"

        val fragmentArgs = bundleOf("name" to name)
        launchFragmentInContainer<AudioBlockFragment>(fragmentArgs)

        // Assert that the fragment is displayed
        Espresso.onView(ViewMatchers.withId(R.id.pindex_block_audio_fragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Assert that the audio name is displayed
        Espresso.onView(ViewMatchers.withId(R.id.pindex_block_audio_button))
            .check(ViewAssertions.matches(ViewMatchers.withText(name)))
    }

}