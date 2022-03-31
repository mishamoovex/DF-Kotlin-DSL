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


subprojects {
    afterEvaluate {
        if (hasProperty("android")) {
            android {
                compileSdk = Dependency.AppConfig.compileSdkVersion

                defaultConfig {
                    minSdk = Dependency.AppConfig.minSdkVersion
                    targetSdk = Dependency.AppConfig.targetSdkVersion
                    testInstrumentationRunner = TestDependency.testRunner
                }

                compileOptions {
                    sourceCompatibility(JavaVersion.VERSION_1_8)
                    targetCompatibility(JavaVersion.VERSION_1_8)
                }

                kotlinOptions {
                    jvmTarget = "1.8"
                }

                buildFeatures {
                    dataBinding = true
                }
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

fun Project.android(configure: Action<com.android.build.gradle.internal.dsl.BaseAppModuleExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

fun com.android.build.gradle.internal.dsl.BaseAppModuleExtension.kotlinOptions(configure: Action<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions>): Unit =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)