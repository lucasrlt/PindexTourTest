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
     * The Pindex blocks fragments arguments names to pass data.
     */
    object BlockFragmentArguments {

        /**
         * The audio block audio path argument.
         */
        const val AUDIO_BLOCK_AUDIO_PATH: String = "audioPath"

        /**
         * The audio block image path argument.
         */
        const val AUDIO_BLOCK_IMAGE_PATH: String = "imagePath"

        /**
         * The audio block name argument.
         */
        const val AUDIO_BLOCK_NAME: String = "name"

        /**
         * The big header block title argument.
         */
        const val BIG_HEADER_BLOCK_TITLE: String = "title"

        /**
         * The borderless image block image path argument.
         */
        const val BORDERLESS_IMAGE_BLOCK_TITLE: String = "imagePath"

        /**
         * The section title block title argument.
         */
        const val SECTION_TITLE_BLOCK_TITLE: String = "title"

        /**
         * The text block text argument.
         */
        const val TEXT_BLOCK_TEXT: String = "text"

    }

    /**
     * The Pindex blocks types.
     */
    object BlocksTypes {

        /**
         * Audio block.
         */
        const val AUDIO: String = "audio"

        /**
         * Big Header block.
         */
        const val BIG_HEADER: String = "bigHeader"

        /**
         * Borderless Image block.
         */
        const val BORDERLESS_IMAGE: String = "borderlessImage"

        /**
         * Text block.
         */
        const val TEXT: String = "text"

    }

    /**
     * Number of experiences to fetch per request.
     */
    const val EXPERIENCES_REPOSITORY_PAGE_SIZE: Long = 10

}