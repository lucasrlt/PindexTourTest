package com.pindex.main.home

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.pindex.main.R
import com.pindex.main.models.BlockDto
import com.pindex.main.models.ExperienceDto
import com.pindex.main.ui.fragments.blocks.*
import com.pindex.main.utils.Constants

class ExperienceActivity : AppCompatActivity() {

    // Activity root layout that contains the experience content
    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experience)

        layout = findViewById(R.id.experience_root_layout)

        // Retrieve the experience from the intent
        val experience: ExperienceDto? = intent.getParcelableExtra(Constants.ACTIVITY_EXPERIENCE_EXTRA_NAME)

        // Get the experience Pindex blocks
        val blocks: ArrayList<BlockDto>? = experience?.content?.get(0)?.blocksWrapper?.blocks

        // Dynamically create a fragment for each Pindex block and add it to the activity
        blocks?.let {
            for (block: BlockDto in blocks) {
                createBlockFragment(block)
            }
        }
    }

    /**
     * Create a fragment based on the given [block] type and
     * content and then add it to the activity root layout.
     */
    private fun createBlockFragment(block: BlockDto) {
        // Create and add a Section Title when the block has a sectionTitle property
        if (block.sectionTitle != null) {
            var sectionTitleBlock = SectionTitleBlockFragment()
            sectionTitleBlock.arguments = bundleOf("title" to block.sectionTitle)

            // Add the Section Title fragment to the root layout
            supportFragmentManager.beginTransaction()
                    .add(R.id.experience_root_layout, sectionTitleBlock)
                    .commit()
        }

        var fragment: Fragment? = null

        // Create a fragment based on the block type
        when (block.type) {
            "audio" -> {
                fragment = AudioBlockFragment()
                fragment.arguments = bundleOf(
                        "audioPath" to block.audio?.audioPath,
                        "imagePath" to block.audio?.imagePath,
                        "name" to block.audio?.name,
                )
            }
            "bigHeader" -> {
                fragment = BigHeaderBlockFragment()
                fragment.arguments = bundleOf("title" to block.text?.text)
            }
            "borderlessImage" -> {
                fragment = BorderlessImageBlockFragment()
                fragment.arguments = bundleOf("imagePath" to block.image?.imagePath)
            }
            "text" -> {
                fragment = TextBlockFragment()
                fragment.arguments = bundleOf("text" to block.text?.text)
            }
        }

        // Add the fragment to the activity root layout
        fragment?.let {
            supportFragmentManager.beginTransaction()
                    .add(R.id.experience_root_layout, fragment)
                    .commit()
        }
    }

}
