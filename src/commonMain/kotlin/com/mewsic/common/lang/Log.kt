package com.mewsic.common.lang

/**
 * Log class polyfill, based on the Android implementation.
 * @constructor Creates a new Log object from a [String] tag
 * @param tag The tag to use for the log
 */
expect class Log(tag: String) {
    var tag: String

    fun changeTag(new: String)


    fun f(message: String)
    fun e(message: String)
    fun w(message: String)
    fun i(message: String)
    fun d(message: String)


    companion object {
        val staticInstance: Log
        fun changeDefaultTag(new: String)


        fun f(message: String)
        fun e(message: String)
        fun w(message: String)
        fun i(message: String)
        fun d(message: String)

    }
}