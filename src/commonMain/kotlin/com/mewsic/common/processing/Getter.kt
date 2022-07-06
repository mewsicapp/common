package com.mewsic.common.processing

import kotlin.reflect.KProperty

class Getter<T>  constructor(
    private val getter: () -> T
) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = getter()
}
