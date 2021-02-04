package com.pindex.main.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BlockDto(
        var type: String? = null
)  : Parcelable

