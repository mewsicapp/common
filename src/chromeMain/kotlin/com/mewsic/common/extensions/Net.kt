package com.mewsic.common.extensions

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val Dispatchers.Net: CoroutineContext
    get() = Dispatchers.Default