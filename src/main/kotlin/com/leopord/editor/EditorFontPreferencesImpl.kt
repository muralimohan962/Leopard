package com.leopord.editor

import java.awt.Font
import javax.swing.JTextArea

class EditorFontPreferencesImpl(private val editor: Editor) : FontPreferences {

    override fun setFont(font: Font) {
        (editor.getComponent() as JTextArea).font = font
    }

    override fun getFont(): Font {
        return (editor.getComponent() as JTextArea).font
    }
}