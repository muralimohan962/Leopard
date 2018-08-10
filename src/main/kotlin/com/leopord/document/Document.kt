package com.leopord.document

import com.leopord.document.listeners.DocumentListener
import com.leopord.document.text.Line
import com.leopord.project.Project

interface Document {

    fun getName(): String

    fun getProject(): Project

    fun getText(): CharSequence

    fun getBytes(): Array<Byte>

    fun setEditable(isEditable: Boolean)

    fun isEditable(): Boolean

    fun addDocumentListener(listener: DocumentListener)

    fun removeDocumentListener(listener: DocumentListener)

    fun setText(text: String)

    fun getLineCount(): Int

    fun getLineStartOffset(line: Int): Int

    fun getLine(offset: Int): Line?

    fun getLines(): Array<Line>
}