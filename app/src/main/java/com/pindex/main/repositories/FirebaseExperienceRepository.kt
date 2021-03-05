package com.pindex.main.repositories

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.pindex.main.auth.PindexFirebase
import com.pindex.main.models.ExperienceDto
import kotlinx.coroutines.tasks.await

/**
 * Experience repository that fetches the data from Firestore.
 */
class FirebaseExperienceRepository : ExperienceRepository {

     // The experiences collection name in Firestore
    private val experiencesCollection: String = "activities"

    // Used in query
    private val queryStatus: String = "status"

    // Used in query
    private val queryStatusListed: String = "listed"

    // Firestore instance
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    // Last experience used to fetch the next chunk of data
    private var lastDocumentSnapshot: DocumentSnapshot? = null

    init {
        // Anonymously log in the user to Firebase
        PindexFirebase.signInAnonymously()
    }

    override suspend fun getPage(limit: Long): List<ExperienceDto> {
        var query = firestore.collection(experiencesCollection)
                .whereEqualTo(queryStatus, queryStatusListed)

        // Fetch the next chunk of data from the last experience
        lastDocumentSnapshot?.let {
            query = query.startAfter(it)
        }

        val result = query
                .limit(limit)
                .get()
                .await()

        // Update the last experience
        lastDocumentSnapshot = result.documents[result.size() - 1]

        return result.toObjects(ExperienceDto::class.java)
    }
}