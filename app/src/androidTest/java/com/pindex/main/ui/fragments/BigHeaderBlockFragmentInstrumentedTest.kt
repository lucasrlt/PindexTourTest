package com.pindex.main.ui.fragments

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pindex.main.R
import com.pindex.main.ui.fragments.blocks.BigHeaderBlockFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BigHeaderBlockFragmentInstrumentedTest {

    @Test
    fun theBigHeaderBlockShouldDisplayItsTitle() {
        val title = "Street Parade 2021"

        val fragmentArgs = bundleOf("title" to title)
        launchFragmentInContainer<BigHeaderBlockFragment>(fragmentArgs)

        Espresso.onView(ViewMatchers.withId(R.id.pindex_block_big_header))
            .check(ViewAssertions.matches(ViewMatchers.withText(title)))
    }

}