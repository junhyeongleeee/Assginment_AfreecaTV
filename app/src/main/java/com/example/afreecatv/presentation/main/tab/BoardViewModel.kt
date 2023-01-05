package com.example.afreecatv.presentation.main.tab

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afreecatv.data.board.BoardRepository
import com.example.afreecatv.data.category.Category
import com.example.afreecatv.presentation.main.tab.BoardFragment.Companion.KEY_CATEGORY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoardViewModel @Inject constructor(
    private val repository: BoardRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val category = savedStateHandle.get<Category>(KEY_CATEGORY)
        ?: throw IllegalStateException("CategoryViewModel - category is null")

    init {
        viewModelScope.launch {
            repository.getBoardList()
        }
    }
}