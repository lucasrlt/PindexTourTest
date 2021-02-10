package com.pindex.main.models.blocks

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TextBlockDto(
    var text: String? = null,
    var expandedOnly: Boolean? = null,
)  : Parcelable
