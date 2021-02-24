package com.pindex.main.repositories

import com.pindex.main.models.ExperienceDto

/**
 * Experience repository interface.
 */
interface ExperienceRepository {

    /**
     * Return a list of ExperienceDto whose size is defined
     * by the given [limit].
     */
    suspend fun getPage(limit: Long): List<ExperienceDto>

}