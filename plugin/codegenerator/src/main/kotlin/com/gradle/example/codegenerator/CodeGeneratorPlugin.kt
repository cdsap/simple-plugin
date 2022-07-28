package com.gradle.example.codegenerator

import net.bytebuddy.build.gradle.ByteBuddyTaskExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class CodeGeneratorPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.apply("java")
        target.plugins.apply("net.bytebuddy.byte-buddy-gradle-plugin")
        target.extensions.configure(ByteBuddyTaskExtension::class.java) {
            transformation {
                plugin = RewriteApiKey::class.java
            }
        }
    }
}
