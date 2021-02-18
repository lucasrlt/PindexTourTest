package com.pindex.main.utils

/**
 * Singleton that provides constants.
 */
object Constants {

    /**
     * The experience activity extra name to pass data.
     */
    const val ACTIVITY_EXPERIENCE_EXTRA_NAME: String = "EXTRA_EXPERIENCE"

    /**
     * The experiences collection name in Firestore.
     */
    const val FIRESTORE_EXPERIENCES_COLLECTION: String = "activities"

    /**
     * Firestore page size value (ViewModel).
     */
    const val FIRESTORE_PAGE_SIZE: Int = 10

    /**
     * The number of documents to fetch per request from Firestore.
     */
    const val FIRESTORE_QUERY_LIMIT: Long = 10
}