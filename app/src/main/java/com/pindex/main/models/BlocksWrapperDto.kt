package com.pindex.main.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BlocksWrapperDto(
        var blocks: ArrayList<BlockDto>? = null,
        var type: BlocksWrapperCategoryEnum? = null,
)  : Parcelable
