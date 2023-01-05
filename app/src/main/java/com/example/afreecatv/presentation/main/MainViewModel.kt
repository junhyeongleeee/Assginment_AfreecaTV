package com.example.afreecatv.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afreecatv.data.category.Category
import com.example.afreecatv.data.category.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    private val repository: CategoryRepository
): ViewModel() {
    private val _categoryListFlow = MutableSharedFlow<List<Category>>()
    val categoryListFlow: SharedFlow<List<Category>> = _categoryListFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _categoryListFlow.emit(repository.getCategoryList())
        }
    }
}