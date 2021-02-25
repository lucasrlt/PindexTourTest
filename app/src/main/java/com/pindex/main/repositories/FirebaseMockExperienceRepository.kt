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
        val experiencesList = ArrayList<ExperienceDto>()

        // Create [limit] experiences and add them to the list
        for (i in 1..limit) {
            val experience = createRandomExperience()
            experiencesList.add(experience)
        }

        return experiencesList
    }

    /**
     * Create and return an ExperienceDto, whose short description
     * and title are random strings.
     */
    private fun createRandomExperience(): ExperienceDto {
        val contentList = ArrayList<ContentDto>()
        val content = ContentDto(
                shortDescription = faker.name.name(),
                title = faker.name.name(),
        )
        contentList.add(content)

        return ExperienceDto(content = contentList, type = "activity")
    }

}