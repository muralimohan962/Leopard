package com.leopord.editor

import com.leopord.document.Document
import com.leopord.editor.listeners.EditorMouseListener
import com.leopord.editor.listeners.EditorMouseMotionListener
import com.leopord.project.Project
import javax.swing.JComponent


/**
 * Represents an instance of an editor.
 */
interface Editor {

    /**
     * Returns the [Document] being edited in this [Editor].
     * @return the [Document] instance being edited.
     */
    fun getDocument(): Document

    /**
     * Returns the [Project] to which this [Editor] belongs.
     * @return the [Project] instance to which this [Editor] belongs.
     */
    fun getProject(): Project

    /**
     * Returns the user interface component fot this [Editor].
     * @return the user interface component.
     */
    fun getComponent(): JComponent

    /**
     * The selection used for selecting the text in this editor.
     * @return the [SelectionModel] of this editor.
     */
    fun getSelectionModel(): SelectionModel

    /**
     * Adds the given [listener] to this [Editor]'s set of mouse listeners.
     * @param listener the listener to add.
     */
    fun addEditorMouseListener(listener: EditorMouseListener)

    /**
     * Adds the given [listener] to this [Editor]'s set of mouse motion listeners.
     * @param listener the listener to add.
     */
    fun addEditorMouseMotionListener(listener: EditorMouseMotionListener)

    /**
     * Removes the given [listener] from this [Editor]'s set of mouse motion listeners.
     * @param listener the listener to remove.
     */
    fun removeEditorMouseListener(listener: EditorMouseListener)

    /**
     * Removes the given [listener] from this [Editor]'s set of mouse motion listeners.
     * @param listener the listener to remove.
     */
    fun removeMouseMotionListener(listener: EditorMouseMotionListener)

    /**
     * Set this [Editor] as view-only meaning un-editable.
     * @param isViewer [true] if editable or false otherwise.
     */
    fun setViewer(isViewer: Boolean)

    /**
     * Returns [true] is this [Editor] is editable or [false].
     * @return [true] if editable of [false] otherwise.
     */
    fun isViewer(): Boolean

    /**
     *
     */
    fun getFontPreferences(): FontPreferences

    /**
     *
     */

}