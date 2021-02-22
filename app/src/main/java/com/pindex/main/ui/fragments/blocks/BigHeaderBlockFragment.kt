package com.pindex.main.ui.fragments.blocks

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.pindex.main.R
import com.pindex.main.utils.Constants

/**
 * Custom Fragment for the Big Header block.
 */
class BigHeaderBlockFragment : Fragment(R.layout.fragment_pindex_block_big_header) {

    private lateinit var textView: AppCompatTextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.pindex_block_big_header)

        // Set the text
        textView.text = arguments?.getString(Constants.BlockFragmentArguments.BIG_HEADER_BLOCK_TITLE)
    }

}
