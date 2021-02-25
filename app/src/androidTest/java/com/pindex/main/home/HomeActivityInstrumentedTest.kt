package com.pindex.main.home

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
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
     * Test that the Home Activity displays the experiences list fragment.
     */
    @Test
    fun launchingHomeActivityDisplaysExperiencesListFragment() {
        onView(withId(R.id.fragment_experiences_list)).check(matches(isDisplayed()))
    }

}