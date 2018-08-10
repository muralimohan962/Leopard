package com.leopord.project.progress

interface ProgressIndicator {

    fun start()

    fun stop()

    fun setIndeterminate(isIndeterminate: Boolean)

    fun setTitle(title: String)

    fun setText(text: String)

    fun isCancelled(): Boolean
}