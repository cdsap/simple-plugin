plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        create("RewriteApiKeyPlugin") {
            id = "com.gradle.example.rewritekey"
            implementationClass = "com.gradle.example.codegenerator.RewriteApiKeyPlugin"
            version = "0.1"
            displayName = "CodeGenerator"
        }
    }
}



repositories {
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
    mavenCentral()
}


dependencies {
    implementation("gradle.plugin.net.bytebuddy:byte-buddy-gradle-plugin:1.12.12")
    implementation("net.bytebuddy:byte-buddy:1.12.12")
    implementation("net.bytebuddy:byte-buddy-agent:1.12.12")
}

