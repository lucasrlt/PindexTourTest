package com.pindex.main.ui.blocks

import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import com.google.android.material.button.MaterialButton
import com.pindex.main.R

/**
 * Custom Button for the Audio block.
 */
class AudioBlock @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : MaterialButton(ContextThemeWrapper(context, R.style.AudioButton), attrs, defStyle)
        //MaterialButton(context, attrs, R.attr.AudioButton)
