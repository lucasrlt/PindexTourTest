package com.pindex.main.models

import com.google.firebase.Timestamp
import com.google.firebase.firestore.GeoPoint

/**
 * An experience can either be a Pindex Tour or a Pindex Activity/Event.
 */
data class ExperienceDto(
        var content: ArrayList<ContentDto>? = null,
        var createdAt: Timestamp? = null,
        var location: GeoPoint? = null,
        var status: String? = null,
        var type: String? = null,
        var updatedAt: Timestamp? = null
)
