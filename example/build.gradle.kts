plugins {
    java
    id("com.gradle.example.codegenerator")
}

java.sourceSets["main"].java.srcDir(tasks.named("codeGenerator"))
