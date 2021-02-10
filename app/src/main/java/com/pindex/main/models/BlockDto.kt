package com.pindex.main.models

import android.os.Parcelable
import com.pindex.main.models.blocks.TextBlock
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BlockDto(
        var type: String? = null,
        var sectionTitle: String ? = null,
        var text: TextBlock? = null,
)  : Parcelable
