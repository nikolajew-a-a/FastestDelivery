package ru.app.fastestdelivery.util

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

inline fun <T> StateFlow<T>.observe(
    owner: LifecycleOwner,
    crossinline onCollect: suspend (T) -> Unit
) = owner.lifecycleScope.launch { owner.repeatOnLifecycle(Lifecycle.State.STARTED) { collect { onCollect(it) } } }

inline fun <T> StateFlow<T>.observeLatest(
    owner: LifecycleOwner,
    crossinline onCollect: suspend (T) -> Unit
) = owner.lifecycleScope.launch { owner.repeatOnLifecycle(Lifecycle.State.STARTED) { collectLatest { onCollect(it) } } }
