package com.leopord.utils

import java.awt.FlowLayout
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.*

class MyWindowListener(private val frame: JFrame) : WindowListener, ActionListener {
    private val myClosingDialog = JDialog(frame)

    init {
        myClosingDialog.layout = GridLayout(2, 1)
        val textArea = JTextArea("Are you sure, you want to close?")
        val buttonCancel = JButton("Cancel")
        val buttonExit = JButton("Exit")
        val buttonPanel = JPanel(FlowLayout(FlowLayout.CENTER, 10, 10))
        buttonPanel.add(buttonCancel)
        buttonPanel.add(buttonExit)

        buttonExit.addActionListener(this)
        buttonCancel.addActionListener(this)

        myClosingDialog.add(textArea)
        myClosingDialog.add(buttonPanel)
    }

    override fun windowDeiconified(e: WindowEvent?) {
        
    }

    override fun windowClosing(e: WindowEvent?) {
        myClosingDialog.isVisible = true
    }

    override fun windowClosed(e: WindowEvent?) {
        windowClosing(e)
    }

    override fun windowActivated(e: WindowEvent?) {
        
    }

    override fun windowDeactivated(e: WindowEvent?) {
        
    }

    override fun windowOpened(e: WindowEvent?) {
        
    }

    override fun windowIconified(e: WindowEvent?) {
        
    }

    override fun actionPerformed(e: ActionEvent?) {
        myClosingDialog.isVisible = false
        println("OK!")
    }
}