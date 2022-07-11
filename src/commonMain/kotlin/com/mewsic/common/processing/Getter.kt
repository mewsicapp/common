package com.mewsic.common.processing

import kotlin.reflect.KProperty

/**
 * [Getter] represents a disconnected value that needs to be dynamically calculated on each access.
 * @constructor Creates a new [Getter] with the given [getter] function.
 * @param [getter] The lambda that calculates the value.
 */
class Getter<T>  constructor(
    private val getter: () -> T
) {
    /**
     * @return The value returned from [getter]
     */
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = getter()
}
