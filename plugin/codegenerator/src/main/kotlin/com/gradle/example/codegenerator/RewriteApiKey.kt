package com.gradle.example.codegenerator

import net.bytebuddy.build.Plugin
import net.bytebuddy.description.type.TypeDescription
import net.bytebuddy.dynamic.ClassFileLocator
import net.bytebuddy.dynamic.DynamicType
import net.bytebuddy.implementation.FixedValue
import net.bytebuddy.matcher.ElementMatchers.named

class RewriteApiKey : Plugin {

    override fun matches(target: TypeDescription?): Boolean {
        return target?.declaredMethods?.filter {
            it.actualName == "getApiKey"
        }?.isNotEmpty() ?: false
    }

    override fun apply(
        builder: DynamicType.Builder<*>, typeDescription: TypeDescription, classFileLocator: ClassFileLocator
    ): DynamicType.Builder<*> {
        return builder.method(named("getApiKey")).intercept(FixedValue.value("ProductionKey"))
    }

    override fun close() {
    }

}
