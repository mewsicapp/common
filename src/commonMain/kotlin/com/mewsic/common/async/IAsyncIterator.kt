package com.mewsic.common.async

import kotlinx.coroutines.Deferred

interface IAsyncIterator<T> : Iterator<Deferred<T>> {
    suspend fun nextAwait(): T
}