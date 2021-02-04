package com.pindex.main.data

import androidx.paging.PagingSource
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.pindex.main.models.ExperienceDto
import kotlinx.coroutines.tasks.await

/**
 * Fetch the experiences from Firestore by chunk.
 */
class ExperiencePagingSource(
    private val db: FirebaseFirestore
) : PagingSource<QuerySnapshot, ExperienceDto>() {

    /**
     * The experiences collection name in Firestore.
     */
    private val FIRESTORE_COLLECTION = "activities"

    /**
     * The number of documents to fetch per request.
     */
    private val QUERY_LIMIT: Long = 10

    override suspend fun load(params: LoadParams<QuerySnapshot>): LoadResult<QuerySnapshot, ExperienceDto> {
        return try {
            // Current chunk of experiences to fetch
            val currentPage = params.key ?: db.collection(FIRESTORE_COLLECTION)
                .limit(QUERY_LIMIT)
                .get()
                .await()

            val lastDocumentSnapshot = currentPage.documents[currentPage.size() - 1]

            // Next chunk of experiences to fetch
            val nextPage = db.collection(FIRESTORE_COLLECTION)
                .limit(QUERY_LIMIT)
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
