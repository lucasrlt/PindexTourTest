package com.pindex.main.home

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pindex.main.R
import com.pindex.main.models.BlockDto
import com.pindex.main.models.BlocksWrapperDto
import com.pindex.main.models.ContentDto
import com.pindex.main.models.ExperienceDto
import com.pindex.main.models.blocks.TextBlockDto
import com.pindex.main.utils.Constants
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExperienceActivityInstrumentedTest {

    /**
     * Test Experience Activity
     */
    private lateinit var activityScenario: ActivityScenario<ExperienceActivity>

    /**
     * Experience Pindex blocks (for a single test at once)
     */
    private var blocksList: ArrayList<BlockDto> = ArrayList()

    @After
    fun tearDown() {
        activityScenario.close()

        // Empty the blocks list for the next test
        blocksList = ArrayList()
    }

    /**
     * Assert that the Experience activity is displayed.
     */
    private fun assertActivityIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.experience_root_layout))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Add the given [block] to the blocks list.
     */
    private fun addBlock(block: BlockDto) {
        blocksList.add(block)
    }

    /**
     * Start the Experience Activity with the current blocks list.
     */
    private fun startActivityWithBlocksList() {
        // Recreate the Firestore Experience structure
        val blocksWrapper = BlocksWrapperDto(blocksList)
        val content = ContentDto(blocksWrapper = blocksWrapper)
        val experience = ExperienceDto(content = arrayListOf(content))

        // Create the activity intent
        val intent = Intent(ApplicationProvider.getApplicationContext(), ExperienceActivity::class.java)
        intent.putExtra(Constants.ACTIVITY_EXPERIENCE_EXTRA_NAME, experience)

        // Starts the activity
        activityScenario = ActivityScenario.launch(intent)
    }

    /**
     * Create and add a Text block with the given [text] to the blocks list.
     */
    private fun addTextBlock(text: String) {
        val textBlock = TextBlockDto(text = text)
        val block = BlockDto(text = textBlock, type = "text")

        addBlock(block)
    }

    /**
     * Tests that the HomeActivity display the recycler view when launched.
     */
    @Test
    fun launchingExperienceActivityWithTextBlockDisplaysItsText() {
        val text = "En fait, c'est pas si terrible que ça le testing Android..."
        addTextBlock(text)

        startActivityWithBlocksList()

        assertActivityIsDisplayed()

        // Assert that the Text block text is displayed
        Espresso.onView(ViewMatchers.withId(R.id.pindex_block_text))
                .check(ViewAssertions.matches(ViewMatchers.withText(text)))
    }

}