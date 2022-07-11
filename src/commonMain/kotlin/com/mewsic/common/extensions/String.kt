package com.mewsic.common.extensions

/**
 * Capitalizes first letter of the string
 */
fun String.capitalizeFirstLetter(): String {
    return lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}
/**
 * Removes all non-alphanumeric characters from the string
 */
fun String.alphanumeric(): String {
    return this.replace(Regex("(?![a-zA-Z\\d])"), "")
}

/**
 * Gets name of enum value in Title Case
 */
fun Enum<*>.toTitleCase(): String {
    return name.split("_").joinToString(" ", transform = String::capitalizeFirstLetter)
}
/**
 * Gets name of enum value in Pascal Case
 */
fun Enum<*>.toPascalCase(): String {
    return name.split("_").joinToString(" ", transform = String::capitalizeFirstLetter)
}
/**
 * Gets name of enum value in snake_case
 */
fun Enum<*>.toSnakeCase(): String {
    return name.split("_").joinToString("_", transform = String::lowercase)
}
/**
 * Gets name of enum value in kebab-case
 */
fun Enum<*>.toKebabCase(): String {
    return name.split("_").joinToString("-", transform = String::lowercase)
}
/**
 * Gets name of enum value in UPPERCASE
 */
fun Enum<*>.toUpperCase(): String {
    return name.split("_").joinToString(" ", transform = String::uppercase)
}
/**
 * Gets name of enum value in lowercase
 */
fun Enum<*>.toLowerCase(): String {
    return name.split("_").joinToString(" ", transform = String::lowercase)
}
/**
 * Gets name of enum value in Train-Case
 */
fun Enum<*>.toTrainCase(): String {
    return name.split("_").joinToString("-", transform = String::capitalizeFirstLetter)
}
