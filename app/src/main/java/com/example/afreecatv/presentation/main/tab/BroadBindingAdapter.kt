package com.example.afreecatv.presentation.main.tab

import androidx.databinding.BindingAdapter
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.afreecatv.presentation.main.adapter.BroadAdapter
import com.example.afreecatv.presentation.main.adapter.BroadModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@BindingAdapter("setRequestManager","setBroadFlow")
fun RecyclerView.initAdapter(
    requestManager: RequestManager,
    broadFlow: Flow<PagingData<BroadModel>>
) {
    if (adapter == null) {
        adapter = BroadAdapter(requestManager)
    }

    findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
        findViewTreeLifecycleOwner()?.repeatOnLifecycle(Lifecycle.State.STARTED) {
            broadFlow.collectLatest {
                (adapter as BroadAdapter).submitData(it)
            }
        }
    }
}
