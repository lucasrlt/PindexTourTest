package com.pindex.main.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import com.pindex.main.R
import com.pindex.main.di.ExperienceRepositoryDI
import com.pindex.main.repositories.ExperienceRepository
import com.pindex.main.repositories.FirebaseMockExperienceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@UninstallModules(ExperienceRepositoryDI::class)
@HiltAndroidTest
class HomeActivityInstrumentedTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val activityScenarioRule = activityScenarioRule<HomeActivity>()

    @Before
    fun init() {
        hiltRule.inject()

        Intents.init()
    }

    @After
    fun clean() {
        Intents.release()
    }

    /**
     * Use the FirebaseMockExperienceRepository for testing.
     */
    @Module
    @InstallIn(ViewModelComponent::class)
    object TestExperienceRepositoryDI {

        @Provides
        @ViewModelScoped
        fun provideExperienceRepositoryInterface(): ExperienceRepository {
            return FirebaseMockExperienceRepository()
        }

    }

    /**
     * Test that the Home activity displays the experiences list fragment
     * and the RecyclerView.
     */
    @Test
    fun launchingHomeActivityDisplaysExperiencesListFragmentAndRecyclerView() {
        // Experiences list Fragment
        onView(withId(R.id.fragment_experiences_list)).check(matches(isDisplayed()))

        // Experiences list RecyclerView
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    /**
     * Test that the Experience activity is displayed after touching an
     * experience from the RecyclerView.
     */
    @Test
    fun clickingOnARecyclerViewItemLaunchesTheExperienceActivity() {
        // Click on the first experience
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        // The Experience activity is displayed
        intended(hasComponent(ExperienceActivity::class.java.name))
    }

}