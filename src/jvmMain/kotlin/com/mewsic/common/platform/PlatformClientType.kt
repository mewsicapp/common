package com.mewsic.common.platform

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*

actual val PlatformClientType: HttpClientEngineFactory<*>
    get() = OkHttp