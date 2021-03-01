package com.pindex.main.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.pindex.main.data.ExperiencePagingSource
import com.pindex.main.repositories.FirebaseExperienceRepository
import com.pindex.main.services.ExperienceService
import com.pindex.main.utils.Constants

/**
 * Experience view model that gets the data from a Pager.
 */
class ExperienceViewModel : ViewModel() {

    val flow = Pager(PagingConfig(Constants.EXPERIENCES_REPOSITORY_PAGE_SIZE.toInt())) {
        ExperiencePagingSource(ExperienceService(FirebaseExperienceRepository()))
    }.flow.cachedIn(viewModelScope)

}