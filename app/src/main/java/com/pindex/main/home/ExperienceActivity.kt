package com.pindex.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.pindex.main.R
import com.pindex.main.models.BlockDto
import com.pindex.main.models.ExperienceDto
import com.pindex.main.ui.blocks.BigHeaderBlock
import com.pindex.main.ui.blocks.SectionTitleBlock
import com.pindex.main.ui.blocks.TextBlock

class ExperienceActivity : AppCompatActivity() {

    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experience)

        layout = findViewById<LinearLayout>(R.id.experience_root_layout)

        val experience: ExperienceDto? = intent.getParcelableExtra("EXPERIENCE")

        // Get the experience Pindex blocks
        val blocks: ArrayList<BlockDto>? = experience?.content?.get(0)?.blocksWrapper?.blocks

        // Dynamically create a widget for each Pindex block and add it to the activity
        for (block: BlockDto in blocks!!) {
            createBlockWidget(block)
        }
    }

    /**
     * Create a widget based on the given [block] type and
     * content and then add it to the activity root layout.
     */
    private fun createBlockWidget(block: BlockDto) {
        var widget: View? = null

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
            params.setMargins(0,0,0,15)
            sectionTitleBlock.layoutParams = params

            // Add the Section Title widget to the root layout
            layout.addView(sectionTitleBlock)
        }

        when (block.type) {
            "bigHeader" -> {
                widget = BigHeaderBlock(this)
                widget.text = block.text?.text
                params.setMargins(0,0,0,50)
            }
            "text" -> {
                widget = TextBlock(this)
                widget.text = block.text?.text
                params.setMargins(0,0,0,50)
            }
        }

        widget?.layoutParams = params

        // Not every block is implemented yet
        if (widget != null) {
            layout.addView(widget)
        }
    }

}
