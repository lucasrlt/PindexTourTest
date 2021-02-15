package com.pindex.main.data

import androidx.paging.PagingSource
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.pindex.main.models.ExperienceDto
import com.pindex.main.utils.Constants
import kotlinx.coroutines.tasks.await

/**
 * Fetch the experiences from Firestore by chunk.
 */
class ExperiencePagingSource(
    private val db: FirebaseFirestore
) : PagingSource<QuerySnapshot, ExperienceDto>() {

    override suspend fun load(params: LoadParams<QuerySnapshot>): LoadResult<QuerySnapshot, ExperienceDto> {
        return try {
            // Current chunk of experiences to fetch
            val currentPage = params.key ?: db.collection(Constants.FIRESTORE_EXPERIENCES_COLLECTION)
                    .whereEqualTo("status", "listed")
                    .limit(Constants.FIRESTORE_QUERY_LIMIT)
                    .get()
                    .await()

            val lastDocumentSnapshot = currentPage.documents[currentPage.size() - 1]

            // Next chunk of experiences to fetch
            val nextPage = db.collection(Constants.FIRESTORE_EXPERIENCES_COLLECTION)
                    .whereEqualTo("status", "listed")
                    .limit(Constants.FIRESTORE_QUERY_LIMIT)
                    .startAfter(lastDocumentSnapshot)
                    .get()
                    .await()

            LoadResult.Page(
                data = currentPage.toObjects(ExperienceDto::class.java),
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
