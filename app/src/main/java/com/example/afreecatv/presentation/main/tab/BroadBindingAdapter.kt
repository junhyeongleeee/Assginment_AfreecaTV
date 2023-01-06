package com.example.afreecatv.presentation.main.tab

import android.util.Log
import androidx.core.os.bundleOf
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.paging.PagingData
import androidx.paging.map
import androidx.recyclerview.widget.RecyclerView
import com.example.afreecatv.R
import com.example.afreecatv.presentation.main.adapter.BroadAdapter
import com.example.afreecatv.presentation.main.model.BroadModel
import com.example.afreecatv.presentation.main.tab.BroadFragment.Companion.KEY_BROAD
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@BindingAdapter("setBroadFlow")
fun RecyclerView.initAdapter(
    broadFlow: Flow<PagingData<BroadModel>>
) {
    if (adapter == null) {
        adapter = BroadAdapter { model ->
            model ?: return@BroadAdapter

            findNavController().navigate(
                R.id.action_mainFragment_to_detailFragment,
                bundleOf(
                    KEY_BROAD to model
                )
            )
        }
    }

    findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
        findViewTreeLifecycleOwner()?.repeatOnLifecycle(Lifecycle.State.STARTED) {
            broadFlow.collectLatest {
                Log.d("RecyclerView", "initAdapter: ${it.map { it.broadNo }}")
                (adapter as BroadAdapter).submitData(it)
            }
        }
    }
}
