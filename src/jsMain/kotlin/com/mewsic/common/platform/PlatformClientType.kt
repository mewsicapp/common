package com.mewsic.common.platform

import io.ktor.client.engine.*
import io.ktor.client.engine.js.*

actual val PlatformClientType: HttpClientEngineFactory<*>
    get() = Js