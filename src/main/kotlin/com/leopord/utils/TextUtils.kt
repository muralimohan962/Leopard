package com.leopord.utils

fun String.removeAtEnd(text: String): String {
    return this.substring(0, this.length - text.length)
}