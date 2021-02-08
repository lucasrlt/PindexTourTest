package com.pindex.main.models.blocks

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageBlock(
        var imageDescription: String? = null,
        var imagePath: String? = null,
)  : Parcelable
