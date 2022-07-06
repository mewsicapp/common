package com.mewsic.common.lang

import kotlinx.datetime.Clock

object System {
    val err: (String) -> Unit = Log.Companion::e
    val out: (String) -> Unit = Log.Companion::i
    // no in for now
    // TODO if you want these, implement them. this is too much that im not going to use for now.
//    fun arraycopy(src: Any, srcPos: Int, dest: Any, destPos: Int, length: Int)
//    fun clearProperty(key: String): String?
//    fun console(): Nothing
    fun currentTimeMillis(): Long = Clock.System.now().toEpochMilliseconds()
//    fun exit(status: Int)
//    fun gc()
//    fun getenv(): Map<String, String>
//    fun getProperties(): Map<String, String>
//    fun getProperty(key: String): String?
//    fun getProperty(key: String, default: String): String
//    fun getSecurityManager(): Nothing
//    fun identityHashCode(x: Any): Int
//    fun inheritedChannel(): Channel?
//    fun lineSeparator(): String
//    fun load(filename: String)
//    fun loadLibrary(libname: String)
//    fun mapLibraryName(libname: String): String
//    fun nanoTime(): Long
//    fun runFinalization()
//    fun setErr(err: Readable)
//    fun setIn(in_: Writable)
//    fun setOut(out: Readable)
//    fun setProperties(props: Map<String, String>)
//    fun setProperty(key: String, value: String)
//    fun setSecurityManager(manager: Any?): Nothing
}