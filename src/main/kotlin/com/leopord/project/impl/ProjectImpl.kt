package com.leopord.project.impl

import com.leopord.project.Project
import java.io.File

class ProjectImpl(private val name: String, private val path: String) : Project {

    init {
        require(File(path).run { exists() && isDirectory }) {
            println("The path doesn't exist or does not point to a valid directory.")
        }
    }

    override fun getName(): String = name

    override fun getPath(): String = path

    override fun getBaseDir(): File = File(path)
}