package com.leopord.document.listeners

import com.leopord.document.events.DocumentEvent

interface DocumentListener {
    fun documentChanged(e: DocumentEvent)
}