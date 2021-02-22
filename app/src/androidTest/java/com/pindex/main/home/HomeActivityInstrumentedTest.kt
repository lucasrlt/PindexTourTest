package com.pindex.main.home

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pindex.main.R
import com.pindex.main.home.HomeActivity
import androidx.test.ext.junit.rules.activityScenarioRule

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class HomeActivityInstrumentedTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<HomeActivity>()

    /**
     * Test that the Home Activity displays the experiences list fragment.
     */
    @Test
    fun launchingHomeActivityDisplaysExperiencesListFragment() {
        onView(withId(R.id.fragment_experiences_list)).check(matches(isDisplayed()))
    }

}