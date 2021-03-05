package com.pindex.main.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.pindex.main.data.ExperiencePagingSource
import com.pindex.main.repositories.ExperienceRepository
import com.pindex.main.services.ExperienceService
import com.pindex.main.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Experience view model that gets the data from a Pager.
 * The experience repository is injected at runtime.
 */
@HiltViewModel
class ExperienceViewModel @Inject constructor(
    private val repository: ExperienceRepository
) : ViewModel() {

    val flow = Pager(PagingConfig(Constants.EXPERIENCES_REPOSITORY_PAGE_SIZE.toInt())) {
        ExperiencePagingSource(ExperienceService(repository))
    }.flow.cachedIn(viewModelScope)

}