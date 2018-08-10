package com.leopord.editor.impl

import com.leopord.document.Document
import com.leopord.editor.Editor
import com.leopord.editor.EditorFactory
import com.leopord.project.Project

class EditorFactoryImpl : EditorFactory() {

    override fun createEditor(project: Project, document: Document): Editor = EditorImpl(project, document)

    override fun createViewer(project: Project, document: Document): Editor =
            EditorImpl(project, document).apply { setViewer(true) }


    companion object {
        private val INSTANCE = EditorFactoryImpl()

        fun getInstance(): EditorFactory = INSTANCE
    }
}