package com.pindex.main.repositories

import com.pindex.main.models.ExperienceDto

interface ExperienceRepository {

    suspend fun getAll(): List<ExperienceDto>

    suspend fun getPage(lastExperience: ExperienceDto? = null): List<ExperienceDto>

    fun getById(id: String): ExperienceDto

}