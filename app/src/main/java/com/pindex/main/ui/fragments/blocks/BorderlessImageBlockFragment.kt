package com.pindex.main.ui.fragments.blocks

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.pindex.main.R
import com.pindex.main.utils.Constants
import com.pindex.main.utils.Converter
import com.pindex.main.utils.MediaLoader

/**
 * Custom Fragment for the Borderless Image block.
 */
class BorderlessImageBlockFragment(
        private val imagePath: String?,
) : Fragment(R.layout.pindex_block_borderless_image) {

    private lateinit var imageView: AppCompatImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.pindex_block_borderless_image)

        // Load the image from Firebase
        imagePath?.let {
            MediaLoader.loadImageFromFirebase(imagePath, imageView)
        }

        // Set the LayoutParams
        var params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
        )
        params.setMargins(
                0,
                0,
                0,
                Constants.BLOCK_BORDERLESS_IMAGE_MARGIN_BOTTOM
        )
        // Set the image height
        context?.let {
            params.height = Converter.dpToPixels(Constants.BLOCK_BORDERLESS_IMAGE_HEIGHT, it)
        }
        view.layoutParams = params
    }

}
