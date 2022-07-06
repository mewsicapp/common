package com.mewsic.common.lang

actual class Log actual constructor(actual var tag: String) {

    actual fun changeTag(new: String) {
        tag = new
    }

    actual fun f(message: String) {
        android.util.Log.wtf(tag, message)
    }

    actual fun e(message: String) {
        android.util.Log.e(tag, message)
    }

    actual fun w(message: String) {
        android.util.Log.w(tag, message)
    }

    actual fun i(message: String) {
        android.util.Log.i(tag, message)
    }

    actual fun d(message: String) {
        android.util.Log.d(tag, message)
    }

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