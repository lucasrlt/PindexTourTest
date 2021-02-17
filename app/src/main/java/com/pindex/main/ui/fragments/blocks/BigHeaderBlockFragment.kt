package com.pindex.main.ui.fragments.blocks

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.pindex.main.R
import com.pindex.main.utils.Constants

/**
 * Custom Fragment for the Big Header block.
 */
class BigHeaderBlockFragment(
        private val title: String?,
) : Fragment(R.layout.pindex_block_big_header) {

    private lateinit var textView: AppCompatTextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.pindex_block_big_header)

        // Set the text
        textView.text = title

        // Set the LayoutParams
        var params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
        )
        params.setMargins(
                Constants.ACTIVITY_EXPERIENCE_CONTENT_MARGIN_X,
                0,
                Constants.ACTIVITY_EXPERIENCE_CONTENT_MARGIN_X,
                Constants.BLOCK_BIG_HEADER_MARGIN_BOTTOM
        )
        view.layoutParams = params
    }

}
