package com.leopord.document.impl

import com.leopord.document.Document
import com.leopord.document.LineSet
import com.leopord.document.events.DocumentEvent
import com.leopord.document.exceptions.ReadOnlyModificationException
import com.leopord.document.listeners.DocumentListener
import com.leopord.document.text.Line
import com.leopord.project.Project

class DocumentImpl(private val name: String, private val project: Project, private var text: String) : Document {
    private var myIsEditable = true
    private val myDocumentListeners = HashMap<Int, DocumentListener>()
    private val myLineSet = LineSet(this)

    init {
        addDocumentListener(myLineSet)
    }

    override fun getName(): String = name

    override fun getProject(): Project = project

    override fun getText(): CharSequence = text

    override fun getBytes(): Array<Byte> = text.toByteArray().toTypedArray()

    override fun setEditable(isEditable: Boolean) {
        myIsEditable = isEditable
    }

    override fun isEditable(): Boolean = myIsEditable

    override fun addDocumentListener(listener: DocumentListener) {
        myDocumentListeners[listener.hashCode()] = listener
    }

    override fun removeDocumentListener(listener: DocumentListener) {
        myDocumentListeners.remove(listener.hashCode())
    }

    override fun setText(text: String) {
        updateText(text)
    }

    private fun updateText(text: String) {
        if(!isEditable())
            throw ReadOnlyModificationException("The document ${getName()} is read-only.")
        this.text = text
        myDocumentListeners.values.forEach { it.documentChanged(DocumentEvent(this@DocumentImpl)) }
    }

    override fun getLineCount(): Int = myLineSet.getLineCount()

    override fun getLineStartOffset(line: Int): Int = myLineSet.getLineStartOffset(line)

    override fun getLine(offset: Int): Line? {
        return myLineSet.getLine(offset)
    }

    override fun getLines(): Array<Line> = myLineSet.getLines()
}