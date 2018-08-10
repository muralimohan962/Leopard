package com.leopord.code.completion

interface CompletionElement {
    fun getElements(text: String): Array<String>?
}