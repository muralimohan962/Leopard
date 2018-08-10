package com.leopord.project

abstract class ProjectManager {

    abstract fun createProject(name: String, path: String): Project

    abstract fun loadProject(name: String, path: String): Project?

    abstract fun openProject(name: String, path: String): Project?
}