package com.leopord.project

import com.leopord.project.impl.ProjectImpl

class ProjectManagerImpl : ProjectManager() {
    private val myProjects = arrayListOf<Project>()

    override fun createProject(name: String, path: String): Project {
        return ProjectImpl(name, path)
    }

    override fun loadProject(name: String, path: String): Project? {
        return createProject(name, path)
    }

    override fun openProject(name: String, path: String): Project? {
        return createProject(name, path)
    }

    companion object {
        private val INSTANCE = ProjectManagerImpl()

        fun getInstance(): ProjectManager = INSTANCE
    }
}