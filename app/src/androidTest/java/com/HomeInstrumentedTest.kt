package com

import android.content.Intent
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
class HomeInstrumentedTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<HomeActivity>()

    /**
     * Tests that the HomeActivity display the recycler view when launched.
     */
    @Test
    fun launchingHomeActivityDisplaysRecyclerView() {
        onView(withId(R.id.home_view)).check(matches(isDisplayed()))
    }

}