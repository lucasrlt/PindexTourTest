package com.pindex.main.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.google.firebase.firestore.FirebaseFirestore
import com.pindex.main.data.ExperiencePagingSource
import com.pindex.main.utils.Constants

class ExperienceViewModel : ViewModel() {

    val flow = Pager(PagingConfig(Constants.FIRESTORE_PAGE_SIZE)) {
        ExperiencePagingSource(FirebaseFirestore.getInstance())
    }.flow.cachedIn(viewModelScope)

}
