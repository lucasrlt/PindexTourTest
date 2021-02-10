package com.pindex.main.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContentDto(
        var id: String? = null,
        var blocksWrapper: BlocksWrapperDto? = null,
        var imagePath: String? = null,
        var lang: String? = null,
        var shortDescription: String? = null,
        var title: String? = null
)  : Parcelable
