package com.leopord.editor

import com.leopord.document.Document
import com.leopord.project.Project

abstract class EditorFactory {

    abstract fun createEditor(project: Project, document: Document): Editor

    fun createEditor(document: Document): Editor = createEditor(document.getProject(), document)

    abstract fun createViewer(project: Project, document: Document): Editor

    fun createViewer(document: Document) = createViewer(document.getProject(), document)
}