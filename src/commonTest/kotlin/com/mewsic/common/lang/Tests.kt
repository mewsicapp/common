package com.mewsic.common.lang

import kotlin.test.Test
import kotlin.test.assertTrue

class Tests {
    @Test
    fun LogWorks() {
        try {
            Log.d("Test")
            assertTrue(true)
        } catch (e: Exception) {
            e.printStackTrace()
            assertTrue(false, "Log.d() failed")
        }
    }
    @Test
    fun TimePasses() {
        val runningTime by time.since(System.currentTimeMillis())
        var somethingToDo = 0
        for (i in 0..1000000) {
            somethingToDo += i
        }
        assertTrue(
            runningTime.inWholeMilliseconds > 0
        )

    }

}