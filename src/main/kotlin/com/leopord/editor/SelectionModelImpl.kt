package com.leopord.editor

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionListener
import javax.swing.JTextArea

class SelectionModelImpl(private val editor: Editor) : SelectionModel, MouseMotionListener, MouseAdapter() {
    private val myTextArea = editor.getComponent() as JTextArea
    private val mySelectionListeners = arrayListOf<SelectionListener>()
    private var mouseDragComplete = false

    init {
        myTextArea.addMouseMotionListener(this)
    }

    override fun getSelectionStart(): Int = myTextArea.selectionStart

    override fun getSelectionEnd(): Int = myTextArea.selectionEnd

    override fun getSelectedText(): String = myTextArea.selectedText

    override fun getSelectedText(startOffset: Int, endOffset: Int): String? {
        val originalStartOffset = myTextArea.selectionStart
        val originalEndOffset = myTextArea.selectionEnd

        return if (startOffset in originalEndOffset..originalEndOffset && endOffset in originalStartOffset..originalEndOffset)
            myTextArea.getText(startOffset, endOffset - startOffset)
        else
            ""
    }

    override fun hasSelection(): Boolean = myTextArea.selectionStart != myTextArea.selectionEnd

    override fun hasSelection(caret: Int): Boolean = myTextArea.selectionStart == caret

    override fun setSelection(startOffset: Int, endOffset: Int) {
        myTextArea.select(startOffset, endOffset)
        notifyListeners()
    }

    override fun mouseDragged(e: MouseEvent?) {
        if (e == null) return
    }

    override fun mouseMoved(e: MouseEvent?) {

    }

    override fun removeSelection() {
        myTextArea.replaceSelection(myTextArea.getText(myTextArea.selectionStart, myTextArea.selectionEnd))
        notifyListeners()
    }

    override fun addSelectionListener(listener: SelectionListener) {
        mySelectionListeners.add(listener)
    }

    override fun removeSelectionListener(listener: SelectionListener) {
        mySelectionListeners.remove(listener)
    }

    private fun notifyListeners() {
        mySelectionListeners.forEach { it.selectionChanged(SelectionEvent(editor)) }
    }

    override fun mouseClicked(e: MouseEvent?) {
        notifyListeners()
    }

    override fun mouseReleased(e: MouseEvent?) {
        notifyListeners()
    }
}