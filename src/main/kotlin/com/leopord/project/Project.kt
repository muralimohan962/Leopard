package com.leopord.project

import java.io.File

interface Project {

    fun getName(): String

    fun getPath(): String

    fun getBaseDir(): File
}