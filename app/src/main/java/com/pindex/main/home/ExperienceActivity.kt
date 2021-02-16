package com.pindex.main.home

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.pindex.main.R
import com.pindex.main.models.BlockDto
import com.pindex.main.models.ExperienceDto
import com.pindex.main.ui.blocks.*
import com.pindex.main.utils.Converter

class ExperienceActivity : AppCompatActivity() {

    private val MARGIN_X = 60

    private val BORDERLESS_IMAGE_HEIGHT = 250

    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experience)

        layout = findViewById<LinearLayout>(R.id.experience_root_layout)

        val experience: ExperienceDto? = intent.getParcelableExtra("EXPERIENCE")

        // Get the experience Pindex blocks
        val blocks: ArrayList<BlockDto>? = experience?.content?.get(0)?.blocksWrapper?.blocks

        // Dynamically create a view for each Pindex block and add it to the activity
        for (block: BlockDto in blocks!!) {
            createBlockView(block)
        }
    }

    /**
     * Create a view based on the given [block] type and
     * content and then add it to the activity root layout.
     */
    private fun createBlockView(block: BlockDto) {
        var view: View? = null

        // Margins are used by the layout ; that is why they are set here
        var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
        )

        // Create and add a Section Title when the block has a sectionTitle property
        if (block.sectionTitle != null) {
            var sectionTitleBlock: SectionTitleBlock = SectionTitleBlock(this)

            sectionTitleBlock.text = block.sectionTitle

            // Set the margins
            params.setMargins(MARGIN_X,0,MARGIN_X,15)
            sectionTitleBlock.layoutParams = params

            // Add the Section Title view to the root layout
            layout.addView(sectionTitleBlock)
        }

        when (block.type) {
            "audio" -> {
                view = AudioBlock(block.audio?.audioPath, block.audio?.imagePath, block.audio?.name, this)
                params.setMargins(MARGIN_X,0,MARGIN_X,50)
            }
            "bigHeader" -> {
                view = BigHeaderBlock(block.text?.text, this)
                params.setMargins(MARGIN_X,0,MARGIN_X,50)
            }
            "borderlessImage" -> {
                view = BorderlessImageBlock(block.image?.imagePath, this)
                // Set the image height here in order to display its background colour
                params.height = Converter.dpToPixels(BORDERLESS_IMAGE_HEIGHT, this)
                params.setMargins(0,0,0,50)
            }
            "text" -> {
                view = TextBlock(block.text?.text, this)
                params.setMargins(MARGIN_X,0,MARGIN_X,50)
            }
        }

        view?.layoutParams = params

        // Not every block is implemented yet
        if (view != null) {
            layout.addView(view)
        }
    }

}
