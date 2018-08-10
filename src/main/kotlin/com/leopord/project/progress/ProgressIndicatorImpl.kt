package com.leopord.project.progress

import java.awt.FlowLayout
import java.awt.GridLayout
import javax.swing.*

class ProgressIndicatorImpl : ProgressIndicator {
    private var myIsCancelled = false
    private var myIsIndeterminate = false
    private var myTitle = ""
    private var myText = ""
    private val myProgressBar = JProgressBar(SwingConstants.HORIZONTAL, 0, 100)
    private val myTitleUI = JTextArea(myTitle)
    private val myCancelBtn = JButton("Cancel")
    private val myProgressIndicatorPanel = JPanel(GridLayout(2, 1)).apply {
        add(myTitleUI)
        val panel = JPanel(FlowLayout(FlowLayout.CENTER, 10, 10))
        panel.add(myProgressBar)
        panel.add(myCancelBtn)
        add(panel)
    }

    override fun start() {
        myProgressIndicatorPanel.isVisible = true
    }

    override fun stop() {
        myProgressIndicatorPanel.isVisible = false
        myIsCancelled = true
    }

    override fun setIndeterminate(isIndeterminate: Boolean) {
        myProgressBar.isIndeterminate = isIndeterminate
    }

    override fun setTitle(title: String) {
        myTitleUI.text = title
    }

    override fun setText(text: String) {
        myText = text
    }

    override fun isCancelled(): Boolean {
        return myIsCancelled
    }
}