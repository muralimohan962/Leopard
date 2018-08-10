package com.leopord.action

import com.leopord.action.events.AnActionEvent
import com.leopord.ui.Presentation
import javax.swing.Icon

abstract class AnAction(text: String? = null, description: String? = null, icon: Icon? = null) {
    private var myPresentation: Presentation? = null

    init {
        val presentation = getTemplatePresentation()

        presentation.text = text
        presentation.description = description
        presentation.icon = icon
        presentation.myHoveredIcon = icon
    }

    abstract fun actionPerformed(e: AnActionEvent)

    abstract fun update()

    fun getTemplatePresentation(): Presentation {
        if (myPresentation == null) {
            myPresentation = Presentation()
        }
        return myPresentation!!
    }
}