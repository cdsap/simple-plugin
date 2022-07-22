package com.gradle.example.codegenerator

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.register

class CodeGeneratorPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.tasks.register<CodeGeneratorTask>("codeGenerator") {
            packageName.set("com.example.gradle")
            classes.set(
                mapOf(
                    "Example" to "class Example {}",
                    "Example21" to "class Example21 { }",
                    "Example3" to "class Example3 { }",
                )
            )
            outputDirectory.set(target.layout.buildDirectory.dir("generated/codegenerator"))
        }
    }
}
