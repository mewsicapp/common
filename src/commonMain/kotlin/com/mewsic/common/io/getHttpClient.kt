package com.mewsic.common.io

import com.mewsic.common.platform.PlatformClientType
import io.ktor.client.*
import io.ktor.client.engine.*

fun getHttpClient(): HttpClient {
    return HttpClient(PlatformClientType)
}
fun <T : HttpClientEngineConfig> getHttpClient(config: HttpClientConfig<T>.() -> Unit): HttpClient {
    @Suppress("UNCHECKED_CAST") // likely story, liberal.
    return HttpClient(PlatformClientType as HttpClientEngineFactory<T>, config)
}