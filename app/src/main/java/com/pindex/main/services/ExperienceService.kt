package com.pindex.main.services

import com.pindex.main.models.ExperienceDto
import com.pindex.main.repositories.ExperienceRepository

/**
 * Experience Service for the Pindex experiences. This class needs
 * a repository in order to get the paginated data.
 */
class ExperienceService (private val repository: ExperienceRepository) {
    /*
    class ExperienceService @Inject constructor (
    private val repository: ExperienceRepository
) {
     */

    /**
     * Use the repository to get the next chunk of data, limited by the
     * given [limit]. The repository handles the pagination keys.
     */
    suspend fun getPage(limit: Long): List<ExperienceDto> {
        return repository.getPage(limit)
    }

}