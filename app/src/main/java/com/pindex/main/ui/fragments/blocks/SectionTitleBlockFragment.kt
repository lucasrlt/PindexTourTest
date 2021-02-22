package com.pindex.main.ui.fragments.blocks

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.pindex.main.R
import com.pindex.main.utils.Constants

/**
 * Custom Fragment for the Section Title block.
 */
class SectionTitleBlockFragment : Fragment(R.layout.fragment_pindex_block_section_title) {

    private lateinit var textView: AppCompatTextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.pindex_block_section_title)

        // Set the text
        textView.text = arguments?.getString(Constants.BlockFragmentArguments.SECTION_TITLE_BLOCK_TITLE )
    }

}
