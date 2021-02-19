package com.pindex.main.ui.fragments

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pindex.main.R
import com.pindex.main.ui.fragments.blocks.SectionTitleBlockFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SectionTitleBlockFragmentInstrumentedTest {

    @Test
    fun theSectionTitleBlockShouldDisplayItsTitle() {
        val title = "Rave au Gadget Club"

        val fragmentArgs = bundleOf("title" to title)
        launchFragmentInContainer<SectionTitleBlockFragment>(fragmentArgs)

        // Assert that the fragment is displayed
        Espresso.onView(ViewMatchers.withId(R.id.pindex_block_section_title_fragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Assert that the section title is displayed
        Espresso.onView(ViewMatchers.withId(R.id.pindex_block_section_title))
            .check(ViewAssertions.matches(ViewMatchers.withText(title)))
    }

}