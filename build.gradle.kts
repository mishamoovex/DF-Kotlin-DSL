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

subprojects {
    afterEvaluate {
        if (isAndroidLibrary()) {
            if (isAppModule()) {
                androidApp {
                    compileSdk = Dep.Gradle.AppConfig.compileSdkVersion

                    defaultConfig {
                        minSdk = Dep.Gradle.AppConfig.minSdkVersion
                        targetSdk = Dep.Gradle.AppConfig.targetSdkVersion
                        testInstrumentationRunner = TestDep.testRunner
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

                    compileSdk = Dep.Gradle.AppConfig.compileSdkVersion

                    defaultConfig {
                        minSdk = Dep.Gradle.AppConfig.minSdkVersion
                        targetSdk = Dep.Gradle.AppConfig.targetSdkVersion
                        testInstrumentationRunner = TestDep.testRunner
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

fun Project.isAndroidLibrary(): Boolean = hasProperty("android")

fun Project.isAppModule(): Boolean = name == "app"

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
