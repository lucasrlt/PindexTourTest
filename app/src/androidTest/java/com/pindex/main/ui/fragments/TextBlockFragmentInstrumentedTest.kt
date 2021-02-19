package com.pindex.main.ui.fragments

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pindex.main.R
import com.pindex.main.ui.fragments.blocks.TextBlockFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TextBlockFragmentInstrumentedTest {

    @Test
    fun theTextBlockShouldDisplayItsText() {
        val text = "« Afin de travailler efficacement, il est conseillé d'aller manger à 11:42 » Le Patron Tim"

        val fragmentArgs = bundleOf("text" to text)
        launchFragmentInContainer<TextBlockFragment>(fragmentArgs)

        // Assert that the fragment is displayed
        Espresso.onView(ViewMatchers.withId(R.id.pindex_block_text_fragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Assert that the text is displayed
        Espresso.onView(ViewMatchers.withId(R.id.pindex_block_text))
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))
    }

}