package com.example.afreecatv.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.afreecatv.presentation.main.model.BroadModel
import com.example.afreecatv.presentation.main.tab.BroadFragment.Companion.KEY_BROAD
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val broad = savedStateHandle.get<BroadModel>(KEY_BROAD)
        ?: throw IllegalStateException("DetailViewModel - broad is null")
}