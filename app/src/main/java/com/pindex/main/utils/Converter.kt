package com.pindex.main.utils

import android.content.Context

/**
 * Singleton that provides conversion functions.
 */
object Converter {

    /**
     * Convert the given [dp] value into pixels. The [context]
     * must be passed as it is used to compute the scale factor.
     */
    fun dpToPixels(dp: Int, context: Context): Int {
        val scale: Float = context.resources.displayMetrics.density

        return (dp * scale + 0.5f).toInt()
    }

}
