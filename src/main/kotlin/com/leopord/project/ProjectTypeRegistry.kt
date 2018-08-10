package com.leopord.project

object ProjectTypeRegistry {
    private val myProjectTypes = arrayListOf<ProjectType>()

    fun registerProjectType(projectType: ProjectType) {
        myProjectTypes.add(projectType)
    }

    fun hasProjectType(projectType: ProjectType): Boolean = myProjectTypes.contains(projectType)

    fun getProjectTypeCount(): Int = myProjectTypes.size

    fun getProjectTypes(): List<ProjectType> = myProjectTypes.toList()
}