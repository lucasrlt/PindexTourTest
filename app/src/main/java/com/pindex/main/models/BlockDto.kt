package com.pindex.main.models

import android.os.Parcelable
import com.pindex.main.models.blocks.AudioBlockDto
import com.pindex.main.models.blocks.ImageBlockDto
import com.pindex.main.models.blocks.TextBlockDto
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BlockDto(
        var audio: AudioBlockDto? = null,
        var image: ImageBlockDto? = null,
        var sectionTitle: String? = null,
        var text: TextBlockDto? = null,
        var type: String? = null,
)  : Parcelable
