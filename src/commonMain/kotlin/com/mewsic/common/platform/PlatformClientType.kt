package com.mewsic.common.platform

import io.ktor.client.*
import io.ktor.client.engine.*

expect val PlatformClientType: HttpClientEngineFactory<*>