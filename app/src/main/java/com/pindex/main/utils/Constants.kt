package com.pindex.main.utils

/**
 * Singleton that provides constants.
 */
object Constants {

    /**
     * The horizontal margin value for the experience activity content.
     */
    const val ACTIVITY_EXPERIENCE_CONTENT_MARGIN_X: Int = 60

    /**
     * The experience activity extra name to pass data.
     */
    const val ACTIVITY_EXPERIENCE_EXTRA_NAME: String = "EXTRA_EXPERIENCE"

    /**
     * The Audio block margin bottom.
     */
    const val BLOCK_AUDIO_MARGIN_BOTTOM: Int = 50

    /**
     * The Big Header block margin bottom.
     */
    const val BLOCK_BIG_HEADER_MARGIN_BOTTOM: Int = 50

    /**
     * The Borderless Image block height value (in px).
     */
    const val BLOCK_BORDERLESS_IMAGE_HEIGHT: Int = 250

    /**
     * The Borderless Image block margin bottom.
     */
    const val BLOCK_BORDERLESS_IMAGE_MARGIN_BOTTOM: Int = 50

    /**
     * The Section Title block margin bottom.
     */
    const val BLOCK_SECTION_TITLE_MARGIN_BOTTOM: Int = 15

    /**
     * The Text block margin bottom.
     */
    const val BLOCK_TEXT_MARGIN_BOTTOM: Int = 50

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