package com.mewsic.common.lang

import com.mewsic.common.processing.Getter
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

object time {
    /**
     * @param [millis] The point in unixtime to get the time from.
     * @return A [Getter] representing the time since the given point in unixtime.
     */
    fun since(millis: Long): Getter<Duration> {
        return Getter {
            return@Getter (System.currentTimeMillis() - millis).milliseconds
        }
    }

}