package com.example.afreecatv.presentation.main.tab

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.afreecatv.data.board.BroadRepository
import com.example.afreecatv.data.category.Category
import com.example.afreecatv.presentation.main.model.BroadModel
import com.example.afreecatv.presentation.main.tab.BroadFragment.Companion.KEY_CATEGORY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class BroadViewModel @Inject constructor(
    private val repository: BroadRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val category = savedStateHandle.get<Category>(KEY_CATEGORY)
        ?: throw IllegalStateException("CategoryViewModel - category is null")

    val broadFlow: Flow<PagingData<BroadModel>> =
        repository.getBroadList(category).cachedIn(viewModelScope)
}