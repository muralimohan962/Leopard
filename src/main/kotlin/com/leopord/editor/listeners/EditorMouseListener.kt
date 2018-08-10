package com.leopord.editor.listeners

import com.leopord.editor.events.EditorMouseEvent

interface EditorMouseListener {

    fun mouseClicked(e: EditorMouseEvent)

    fun mousePressed(e: EditorMouseEvent)

    fun mouseReleased(e: EditorMouseEvent)

    fun mouseEntered(e: EditorMouseEvent)

    fun mouseExited(e: EditorMouseEvent)
}