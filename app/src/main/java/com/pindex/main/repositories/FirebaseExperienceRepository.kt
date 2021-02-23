package com.pindex.main.repositories

import android.util.Log
import androidx.paging.PagingSource
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.toObject
import com.pindex.main.models.ExperienceDto
import com.pindex.main.utils.Constants
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import kotlin.math.exp

class FirebaseExperienceRepository : /*ExperienceRepository,*/
    PagingSource<ExperienceDto, ExperienceDto>() {

    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
/*
    override suspend fun getAll(): List<ExperienceDto> {
        return firestore.collection(Constants.FIRESTORE_EXPERIENCES_COLLECTION)
            .get()
            .await()
            .toObjects(ExperienceDto::class.java)
    }

 */
    /*
    suspend fun getPage(lastExperience: ExperienceDto?): ExperienceDto {
        var currentPage = firestore.collection((Constants.FIRESTORE_EXPERIENCES_COLLECTION))
            .whereEqualTo("status", "listed")
            .limit(Constants.FIRESTORE_QUERY_LIMIT)

        lastExperience?.let {
            currentPage = currentPage.startAfter(lastExperience)
        }

        return currentPage.get()
            //.await()
            //.toObjects(ExperienceDto::class.java)
    }

     */

    /*
    override fun getById(id: String): ExperienceDto {
        TODO("Not yet implemented")
    }

     */

    fun getPage(): List<ExperienceDto> {
        val experiences = ArrayList<ExperienceDto>()

        firestore.collection((Constants.FIRESTORE_EXPERIENCES_COLLECTION))
                .whereEqualTo("status", "listed")
                .limit(Constants.FIRESTORE_QUERY_LIMIT)
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result!!) {
                            experiences.add(document.toObject(ExperienceDto::class.java))
                            Log.d("BIBOU", document.toString())
                        }

                        Log.d("BIBOU", experiences.size.toString())

                    }
                }

        return experiences
    }

    override suspend fun load(params: LoadParams<ExperienceDto>): LoadResult<ExperienceDto, ExperienceDto> {
        return try {
            val currentPage = getPage()

            val nextPage = currentPage[currentPage.lastIndex]

            LoadResult.Page(
                data = currentPage,
                prevKey = null,
                nextKey = nextPage,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

}