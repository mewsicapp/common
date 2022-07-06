package com.mewsic.common.lang

import com.mewsic.common.processing.Getter
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

object time {

    fun since(millis: Long): Getter<Duration> {
        return Getter {
            return@Getter (System.currentTimeMillis() - millis).milliseconds
        }
    }

}