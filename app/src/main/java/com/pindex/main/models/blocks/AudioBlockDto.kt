package com.pindex.main.models.blocks

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AudioBlockDto(
    var audioPath: String? = null,
    var imagePath: String? = null,
    var name: String? = null,
) : Parcelable
