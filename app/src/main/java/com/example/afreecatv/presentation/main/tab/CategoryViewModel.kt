package com.example.afreecatv.presentation.main.tab

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.afreecatv.presentation.main.model.Category
import com.example.afreecatv.presentation.main.tab.CategoryFragment.Companion.KEY_CATEGORY
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val category = savedStateHandle.get<Category>(KEY_CATEGORY)
        ?: throw IllegalStateException("CategoryViewModel - category is null")

}