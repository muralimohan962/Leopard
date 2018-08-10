package com.leopord.document

import com.leopord.document.events.DocumentEvent
import com.leopord.document.listeners.DocumentListener
import com.leopord.document.text.Line

class LineSet(val document: Document) : DocumentListener {
    private var myLineNo2Line: MutableMap<Int, Line>? = mutableMapOf()

    init {
        updateLineSet()
    }

    fun getLineCount(): Int = document.getText().split("\n").size

    fun getLineStartOffset(line: Int): Int {
        return myLineNo2Line!![line]!!.startOffset
    }

    fun getEndOffset(line: Int): Int {
        return myLineNo2Line!![line]!!.endOffset
    }

    fun getLines(): Array<Line> {
        val lines = arrayListOf<Line>()
        document.getText().split("\n").forEach {
            val (startOffset, endOffset) = getLineOffsets(it)
            lines.add(Line(it, startOffset, endOffset))
        }

        return lines.toTypedArray()
    }

    override fun documentChanged(e: DocumentEvent) {
        updateLineSet()
    }

    private fun updateLineSet() {
        myLineNo2Line = null
        myLineNo2Line = mutableMapOf()

        getLines().forEachIndexed { index, line -> myLineNo2Line!![index] = line }
    }

    private fun getLineOffsets(text: String): Pair<Int, Int> {
        var startOffset: Int = 0
        var endOffset: Int = 0

        text.forEach {
            if (it == ' ')
                startOffset++
        }

        endOffset = startOffset + text.trim().length

        return Pair(startOffset, endOffset)
    }

    fun getLine(offset: Int): Line? {
        myLineNo2Line!!.values.forEach {
            if (it.startOffset == offset || it.endOffset == offset)
                return it
        }
        return null
    }
}