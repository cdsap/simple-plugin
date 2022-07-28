plugins {
    id("com.gradle.example.codegenerator")
}

tasks.register<com.gradle.example.codegenerator.JavaGeneratorTask>("javaGeneratorTask") {
    packageName.set("com.example.gradle")
    classes.set(
        mapOf(
            "Example" to "class Example { public String getApiKey() {return \"ANOTHER_DEPLOYMENT_KEY\"; } }",
            "ExampleNoApiKey" to "class ExampleNoApiKey { }",
        )
    )
    outputDirectory.set(layout.projectDirectory.dir("generated/java"))
}

java.sourceSets["main"].java.srcDir(tasks.named("javaGeneratorTask"))

dependencies {
    testImplementation("junit:junit:4.13.2")
}
