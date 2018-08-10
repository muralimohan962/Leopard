package com.leopord.editor.impl

import com.leopord.code.completion.CompletionElementImpl
import com.leopord.document.Document
import com.leopord.editor.*
import com.leopord.editor.events.EditorMouseEvent
import com.leopord.editor.listeners.EditorMouseListener
import com.leopord.editor.listeners.EditorMouseMotionListener
import com.leopord.project.Project
import com.leopord.utils.removeAtEnd
import java.awt.Color
import java.awt.Dimension
import java.awt.event.*
import java.lang.StringBuilder
import javax.swing.JComponent
import javax.swing.JTextArea

class EditorImpl(private val project: Project, private val document: Document) : Editor, MouseMotionListener, MouseListener {
    private var myIsViewer = false
    private val myEditorComponent = JTextArea(document.getText().toString())
    private val myEditorMouseListeners = HashMap<Int, EditorMouseListener>()
    private val myEditorMouseMotionListeners = HashMap<Int, EditorMouseMotionListener>()
    private val myEditorFontPreferences = EditorFontPreferencesImpl(this)
    private val mySelectionModel = SelectionModelImpl(this)

    init {
        myEditorComponent.run {
            addMouseListener(this@EditorImpl)
            addMouseMotionListener(this@EditorImpl)
            minimumSize = Dimension(900, 400)

            background = Color.decode("#4C4A4B")
            foreground = Color.WHITE
            selectionColor = Color.decode("#0C19FF")
            caretColor = Color.WHITE
            selectedTextColor = Color.WHITE
        }

        myEditorComponent.addKeyListener(object : KeyListener {
            private val keyChars = arrayListOf<Char>()
            private var time = System.currentTimeMillis()
            private val completionElement = CompletionElementImpl()

            override fun keyTyped(e: KeyEvent?) {
                if (System.currentTimeMillis() - time <= 100)
                    keyChars.add(e!!.keyChar)
                else {
                    time = System.currentTimeMillis()
                    val elements = completionElement.getElements(getText()) ?: return

                    myEditorComponent.text = myEditorComponent.text.removeAtEnd(getText()) + elements.first()
                }
            }

            override fun keyPressed(e: KeyEvent?) {

            }

            override fun keyReleased(e: KeyEvent?) {

            }

            private fun getText(): String {
                val text = StringBuilder()
                keyChars.forEach { text.append(it) }
                return text.toString()
            }
        })
    }

    override fun getDocument(): Document = document

    override fun getProject(): Project = project

    override fun getComponent(): JComponent = myEditorComponent

    override fun setViewer(isViewer: Boolean) {
        myIsViewer = isViewer
        myEditorComponent.isEditable = !myIsViewer
    }

    override fun isViewer(): Boolean = myIsViewer

    override fun addEditorMouseListener(listener: EditorMouseListener) {
        myEditorMouseListeners[listener.hashCode()] = listener
    }

    override fun addEditorMouseMotionListener(listener: EditorMouseMotionListener) {
        myEditorMouseMotionListeners[listener.hashCode()] = listener
    }

    override fun removeEditorMouseListener(listener: EditorMouseListener) {
        myEditorMouseListeners.remove(listener.hashCode())
    }

    override fun removeMouseMotionListener(listener: EditorMouseMotionListener) {
        myEditorMouseMotionListeners.remove(listener.hashCode())
    }

    override fun mouseMoved(e: MouseEvent?) {
        myEditorMouseMotionListeners.values.forEach { it.mouseMoved(EditorMouseEvent(this@EditorImpl, e!!)) }
    }

    override fun mouseDragged(e: MouseEvent?) {
        myEditorMouseMotionListeners.values.forEach { it.mouseDragged(EditorMouseEvent(this@EditorImpl, e!!)) }
    }

    override fun mouseReleased(e: MouseEvent?) {
        myEditorMouseListeners.values.forEach { it.mouseReleased(EditorMouseEvent(this@EditorImpl, e!!)) }
    }

    override fun mouseEntered(e: MouseEvent?) {
        myEditorMouseListeners.values.forEach { it.mouseEntered(EditorMouseEvent(this@EditorImpl, e!!)) }
    }

    override fun mouseClicked(e: MouseEvent?) {
        myEditorMouseListeners.values.forEach { it.mouseClicked(EditorMouseEvent(this@EditorImpl, e!!)) }
    }

    override fun mouseExited(e: MouseEvent?) {
        myEditorMouseListeners.values.forEach { it.mouseExited(EditorMouseEvent(this@EditorImpl, e!!)) }
    }

    override fun mousePressed(e: MouseEvent?) {
        myEditorMouseListeners.values.forEach { it.mousePressed(EditorMouseEvent(this@EditorImpl, e!!)) }
    }

    override fun getFontPreferences(): FontPreferences {
        return myEditorFontPreferences
    }

    override fun getSelectionModel(): SelectionModel = mySelectionModel
}