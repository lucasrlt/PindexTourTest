package com.pindex.main.data

import androidx.paging.PagingSource
import com.pindex.main.models.ExperienceDto
import com.pindex.main.services.ExperienceService
import com.pindex.main.utils.Constants

/**
 * Paging Source for the Pindex experiences. This class needs an
 * ExperienceService in order to get the paginated data.
 */
class ExperiencePagingSource(private val service: ExperienceService) : PagingSource<List<ExperienceDto>, ExperienceDto>() {

    override suspend fun load(params: LoadParams<List<ExperienceDto>>): LoadResult<List<ExperienceDto>, ExperienceDto> {
        return try {
            // If no key is passed, get the first chunk of data
            val currentPage = params.key ?: service.getPage(Constants.FIRESTORE_QUERY_LIMIT)

            // Next chunk of data
            val nextPage = service.getPage(Constants.FIRESTORE_QUERY_LIMIT)

            LoadResult.Page(
                data = currentPage,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
