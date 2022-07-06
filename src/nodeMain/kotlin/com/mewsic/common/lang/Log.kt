package com.mewsic.common.lang

actual class Log actual constructor(actual var tag: String) {
    actual fun changeTag(new: String) {
        tag = new
    }

    actual fun f(message: String) = println("[FATAL] $tag: $message")

    actual fun e(message: String) = println("[ERROR] $tag: $message")

    actual fun w(message: String) = println("[WARN] $tag: $message")

    actual fun i(message: String) = println("[INFO] $tag: $message")

    actual fun d(message: String) = println("[DEBUG] $tag: $message")

    actual companion object {
        actual val staticInstance: Log = Log("com/mewsic/common/lang/Log")

        actual fun changeDefaultTag(new: String) = staticInstance.changeTag(new)

        actual fun f(message: String) = staticInstance.f(message)

        actual fun e(message: String) = staticInstance.e(message)

        actual fun w(message: String) = staticInstance.w(message)

        actual fun i(message: String) = staticInstance.i(message)

        actual fun d(message: String) = staticInstance.d(message)
    }


}