package com.mewsic.common.platform

import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*

actual val PlatformClientType: HttpClientEngineFactory<*>
    get() = CIO // FIXME: i dont know how to change it to Darwin if host is MacOS, then again is it really needed?