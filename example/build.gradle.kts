plugins {
    java
    id("com.gradle.example.codegenerator")
}

// 1- Registering "codeGenerator" task. This task will generate a collection of Java classes in folder generated/java
tasks.register<com.gradle.example.codegenerator.CodeGeneratorTask>("codeGenerator") {
    packageName.set("com.example.gradle")
    classes.set(
        mapOf(
            "Example" to "class Example {}",
            "Example21" to "class Example21 { }",
        )
    )
    outputDirectory.set(layout.projectDirectory.dir("generated/java"))
}

// 2- Wiring the new task codeGenerator with main java source set
java.sourceSets["main"].java.srcDir(tasks.named("codeGenerator"))

// 3- Task adding existing classes to the jar output.
tasks.register<Jar>("jarWithClasses") {
    dependsOn("jar")
    archiveBaseName.set("${project.name}-all")
    from(project.zipTree(project.tasks.named("jar").get().outputs.files.asPath))
    from(layout.projectDirectory.dir("generated/classes"))
}

