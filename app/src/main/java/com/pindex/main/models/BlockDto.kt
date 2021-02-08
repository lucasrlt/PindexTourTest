package com.pindex.main.models

import android.os.Parcelable
import com.pindex.main.models.blocks.ImageBlock
import com.pindex.main.models.blocks.TextBlock
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BlockDto(
        var image: ImageBlock? = null,
        var sectionTitle: String? = null,
        var text: TextBlock? = null,
        var type: String? = null,
)  : Parcelable
