package com.leopord.editor

import java.util.*

class SelectionEvent(source: Editor) : EventObject(source) {

    fun getEditor(): Editor {
        return source as Editor
    }
}