package com.leopord.editor.listeners

import com.leopord.editor.events.EditorMouseEvent

interface EditorMouseMotionListener {

    fun mouseMoved(e: EditorMouseEvent)

    fun mouseDragged(e: EditorMouseEvent)
}