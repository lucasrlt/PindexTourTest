package com.pindex.main.repositories

import com.pindex.main.models.ContentDto
import com.pindex.main.models.ExperienceDto
import io.github.serpro69.kfaker.Faker

/**
 * Mocked Firebase for testing.
 */
class FirebaseMockExperienceRepository : ExperienceRepository {

    /**
     * Data Faker
     */
    private val faker = Faker()

    override suspend fun getPage(limit: Long): List<ExperienceDto> {
        // Create [limit] experiences and return them in an array
        return Array(limit.toInt()) { createRandomExperience() }.toCollection(ArrayList())
    }

    /**
     * Create and return an ExperienceDto, whose short description
     * and title are random strings.
     */
    private fun createRandomExperience(): ExperienceDto {
        return ExperienceDto(
                content = arrayListOf(
                    ContentDto(
                            shortDescription = faker.name.name(),
                            title = faker.name.name()
                    )
                ),
                type = "activity",
        )
    }

}