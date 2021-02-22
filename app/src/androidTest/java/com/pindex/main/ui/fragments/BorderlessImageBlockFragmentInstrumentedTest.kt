package com.pindex.main.ui.fragments

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pindex.main.R
import com.pindex.main.ui.fragments.blocks.BorderlessImageBlockFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BorderlessImageBlockFragmentInstrumentedTest {

    @Test
    fun borderlessImageBlockShouldBeDisplayed() {
        launchFragmentInContainer<BorderlessImageBlockFragment>()

        // Assert that the fragment is displayed
        Espresso.onView(ViewMatchers.withId(R.id.pindex_block_borderless_image_fragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}