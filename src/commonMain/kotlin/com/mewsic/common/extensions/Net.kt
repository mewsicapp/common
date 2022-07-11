package com.mewsic.common.extensions

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * [Dispatchers.Net] links to [Dispatchers.IO] where available and [Dispatchers.Default] otherwise.
 */
expect val Dispatchers.Net: CoroutineContext // using Net instead of IO to resolve issue with android already having it defined