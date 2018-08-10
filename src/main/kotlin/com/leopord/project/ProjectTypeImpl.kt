package com.leopord.project

import javax.swing.Icon
import javax.swing.JComponent

class ProjectTypeImpl(
        private val name: String,
        private val icon: Icon? = null,
        private val component: JComponent) : ProjectType {

    override fun getName(): String = name

    override fun getIcon(): Icon? = icon

    override fun getComponent(): JComponent = component

    override fun toString(): String = getName()
}