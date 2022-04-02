plugins {
    id("com.android.application") version Dep.Gradle.version apply false
    id("com.android.library") version Dep.Gradle.version apply false
    id("org.jetbrains.kotlin.android") version Dep.Kotlin.version apply false
}

buildscript {

    dependencies {
        classpath(Dep.Jetpack.Navigation.SafeArgs.gradlePlugin)
        classpath(Dep.Firebase.gradlePlugin)
        classpath(Dep.Firebase.Crashlytics.gradlePlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
