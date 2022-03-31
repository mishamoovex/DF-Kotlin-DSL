plugins {
    id("com.android.application") version Dependency.Gradle.version apply false
    id("com.android.library") version Dependency.Gradle.version apply false
    id("org.jetbrains.kotlin.android") version Dependency.Kotlin.version apply false
}

buildscript {

    dependencies {
        classpath(Dependency.Jetpack.Hilt.plugin)
        classpath(Dependency.Jetpack.Navigation.SafeArgs.plugin)
    }
}

subprojects {
    afterEvaluate {
        if (hasProperty("android")) {
            if (name == "app") {
                androidApp {
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

                    kotlinOptionsApp {
                        jvmTarget = "1.8"
                    }

                }
            } else {
                androidLib {

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

                    kotlinOptionsLib {
                        jvmTarget = "1.8"
                    }
                }
            }
        }
    }
}

fun Project.androidApp(configure: Action<com.android.build.gradle.internal.dsl.BaseAppModuleExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

fun com.android.build.gradle.internal.dsl.BaseAppModuleExtension.kotlinOptionsApp(configure: Action<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions>): Unit =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)

fun Project.androidLib(configure: Action<com.android.build.gradle.LibraryExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

fun com.android.build.gradle.LibraryExtension.kotlinOptionsLib(configure: Action<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions>): Unit =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)




tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
