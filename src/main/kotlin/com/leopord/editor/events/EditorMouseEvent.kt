package com.leopord.editor.events

import com.leopord.editor.Editor
import java.awt.event.MouseEvent
import java.util.*

class EditorMouseEvent(editor: Editor, val mouseEvent: MouseEvent) : EventObject(editor)