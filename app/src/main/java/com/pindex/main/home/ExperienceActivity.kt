package com.pindex.main.home

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.pindex.main.R
import com.pindex.main.models.BlockDto
import com.pindex.main.models.ExperienceDto
import com.pindex.main.ui.blocks.*
import com.pindex.main.utils.Constants
import com.pindex.main.utils.Converter

class ExperienceActivity : AppCompatActivity() {

    /**
     * Horizontal margin for this activity content ; declared here
     * because used multiple times.
     */
    private val contentMarginX: Int = Constants.ACTIVITY_EXPERIENCE_CONTENT_MARGIN_X

    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experience)

        layout = findViewById<LinearLayout>(R.id.experience_root_layout)

        val experience: ExperienceDto? = intent.getParcelableExtra(Constants.ACTIVITY_EXPERIENCE_EXTRA_NAME)

        // Get the experience Pindex blocks
        val blocks: ArrayList<BlockDto>? = experience?.content?.get(0)?.blocksWrapper?.blocks

        // Dynamically create a widget for each Pindex block and add it to the activity
        blocks?.let {
            for (block: BlockDto in blocks) {
                createBlockWidget(block)
            }
        }
    }

    /**
     * Create a widget based on the given [block] type and
     * content and then add it to the activity root layout.
     */
    private fun createBlockWidget(block: BlockDto) {
        var view: View? = null

        // Margins are used by the layout ; that is why they are set here
        var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
        )

        // Create and add a Section Title when the block has a sectionTitle property
        if (block.sectionTitle != null) {
            var sectionTitleBlock: SectionTitleBlock = SectionTitleBlock(block.sectionTitle, this)

            // Set the margins
            params.setMargins(contentMarginX,0,contentMarginX,Constants.BLOCK_SECTION_TITLE_MARGIN_BOTTOM)
            sectionTitleBlock.layoutParams = params

            // Add the Section Title widget to the root layout
            layout.addView(sectionTitleBlock)
        }

        when (block.type) {
            "audio" -> {
                view = AudioBlock(block.audio?.audioPath, block.audio?.imagePath, block.audio?.name, this)
                params.setMargins(contentMarginX,0,contentMarginX,Constants.BLOCK_AUDIO_MARGIN_BOTTOM)
            }
            "bigHeader" -> {
                view = BigHeaderBlock(block.text?.text, this)
                params.setMargins(contentMarginX,0,contentMarginX,Constants.BLOCK_BIG_HEADER_MARGIN_BOTTOM)
            }
            "borderlessImage" -> {
                view = BorderlessImageBlock(block.image?.imagePath, this)
                // Set the image height here in order to display its background colour
                params.height = Converter.dpToPixels(Constants.BLOCK_BORDERLESS_IMAGE_HEIGHT, this)
                params.setMargins(0,0,0,Constants.BLOCK_BORDERLESS_IMAGE_MARGIN_BOTTOM)
            }
            "text" -> {
                view = TextBlock(block.text?.text, this)
                params.setMargins(contentMarginX,0,contentMarginX,Constants.BLOCK_TEXT_MARGIN_BOTTOM)
            }
        }

        view?.layoutParams = params

        // Not every block is implemented yet
        if (view != null) {
            layout.addView(view)
        }
    }

}
