// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version Dependency.Gradle.version apply false
    id("com.android.library") version Dependency.Gradle.version apply false
    id("org.jetbrains.kotlin.android") version Dependency.Kotlin.version apply false
}

buildscript{

    dependencies{
        classpath(Dependency.Jetpack.Hilt.plugin)
        classpath(Dependency.Jetpack.Navigation.SafeArgs.plugin)
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}