package com.pindex.main.models.blocks

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TextBlock(
    var text: String? = null,
    var expandedOnly: Boolean? = null,
)  : Parcelable
