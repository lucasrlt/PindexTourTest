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
class BorderlessImageBlockFragment : Fragment(R.layout.pindex_block_borderless_image) {

    private lateinit var imageView: AppCompatImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.pindex_block_borderless_image)

        // Load the image from Firebase
        val imagePath = arguments?.getString("imagePath")
        imagePath?.let {
            MediaLoader.loadImageFromFirebase(imagePath, imageView)
        }
    }

}
