package com.leopord.ui

import javax.swing.JFrame

object IdeFrameFactory {

    fun createSimpleIdeFrame(title: String = ""): JFrame {
        return JFrame(title)
    }
}