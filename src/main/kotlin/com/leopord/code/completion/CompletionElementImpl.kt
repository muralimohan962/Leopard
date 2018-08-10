package com.leopord.code.completion

class CompletionElementImpl : CompletionElement {
    private val words = arrayListOf("public", "class", "static", "void", "main", "String", "int", "return")


    override fun getElements(text: String): Array<String>? {
        val completionString = arrayListOf<String>()

        words.forEach {
            if (it.startsWith(text, ignoreCase = true))
                completionString.add(it)
        }

        return if (completionString.isEmpty()) null else completionString.toTypedArray()
    }
}