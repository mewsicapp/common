package com.mewsic.common.io

import com.mewsic.common.platform.PlatformClientType
import io.ktor.client.*
import io.ktor.client.engine.*

/**
 *
 * @return [HttpClient] best suited for the current platform
 *
 */
fun getHttpClient(): HttpClient {
    return HttpClient(PlatformClientType)
}

/**
 * @param [config] configuration of the client
 * @return [HttpClient] best suited for the current platform
 */
fun <T : HttpClientEngineConfig> getHttpClient(config: HttpClientConfig<T>.() -> Unit): HttpClient {
    @Suppress("UNCHECKED_CAST") // likely story, liberal.
    return HttpClient(PlatformClientType as HttpClientEngineFactory<T>, config)
}