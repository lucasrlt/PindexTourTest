package com

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pindex.main.R
import com.pindex.main.home.ExperienceActivity
import com.pindex.main.home.HomeActivity
import com.pindex.main.ui.fragments.blocks.BigHeaderBlockFragment
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<HomeActivity>()

    @Test
    fun testBigHeaderBlockFragment() {
        val fragmentArgs = bundleOf("title" to "Street Parade 2021")
        //val scenario = launchFragment<BigHeaderBlockFragment>(fragmentArgs)
        //val scenario = launchFragmentInContainer<BigHeaderBlockFragment>(fragmentArgs)

        //Espresso.onView(ViewMatchers.withId(R.id.pindex_block_big_header)).check(ViewAssertions.matches(ViewMatchers.withText("Street Parade 2021")))
    }

}