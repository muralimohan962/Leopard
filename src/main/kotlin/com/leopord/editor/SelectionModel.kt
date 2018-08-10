package com.leopord.editor

interface SelectionModel {

    /**
     * Returns the start offset of the selected text or caret position if there is no selection.
     * @return the selected text start offset or current caret position.
     */
    fun getSelectionStart(): Int

    /**
     * Returns the selected text.
     * @return the selected text.
     */
    fun getSelectedText(): String

    /**
     * Returns the text from [startOffset] until [endOffset] in the selected text or null if there is no selection in the text.
     * @param startOffset the start offset of the text.
     * @param endOffset the end offset of the text.
     * @return the selected text from [startOffset] to [endOffset].
     */
    fun getSelectedText(startOffset: Int, endOffset: Int): String?

    /**
     * Returns true if there is any selected text or false.
     * @return true if text has selection or false.
     */
    fun hasSelection(): Boolean

    /**
     * Returns the end offset of the selection if the text has any selection or current caret position if not.
     * @return the end offset of the selected text or current caret position.
     */
    fun getSelectionEnd(): Int

    /**
     * Returns true if there is selection at the caret position or false if not.
     * @return true if has selection or false if not.
     */
    fun hasSelection(caret: Int): Boolean

    /**
     * Selects the text from [startOffset] until [endOffset].
     * @param startOffset the start offset of the text.
     * @param endOffset the end offset of the text.
     */
    fun setSelection(startOffset: Int, endOffset: Int)

    /**
     *
     */
    fun removeSelection()

    /**
     *
     */
    fun addSelectionListener(listener: SelectionListener)

    /**
     *
     */
    fun removeSelectionListener(listener: SelectionListener)
}