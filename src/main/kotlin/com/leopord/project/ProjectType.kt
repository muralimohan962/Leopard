package com.leopord.project

import javax.swing.Icon
import javax.swing.JComponent

interface ProjectType {

    fun getName(): String

    fun getIcon(): Icon?

    fun getComponent(): JComponent
}