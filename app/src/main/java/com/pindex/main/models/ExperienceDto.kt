package com.pindex.main.models

import com.google.firebase.Timestamp
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/**
 * An experience can either be a Pindex Tour or a Pindex Activity/Event.
 */
@Parcelize
data class ExperienceDto(
        var content: ArrayList<ContentDto>? = null,
        var createdAt: Timestamp? = null,
        // FIXME: is not parcelable
        //var location: @RawValue GeoPoint? = null,
        var status: String? = null,
        var type: String? = null,
        var updatedAt: Timestamp? = null
)  : Parcelable
