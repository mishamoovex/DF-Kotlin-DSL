plugins {
    id("com.android.application") version Dep.Gradle.version apply false
    id("com.android.dynamic-feature") version "7.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false

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
                application {
                    compileSdk = Dep.Gradle.AppConfig.compileSdkVersion

                    defaultConfig {
                        minSdk = Dep.Gradle.AppConfig.minSdkVersion
                        targetSdk = Dep.Gradle.AppConfig.targetSdkVersion
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
                dynamicFeature {
                    compileSdk = Dep.Gradle.AppConfig.compileSdkVersion

                    defaultConfig {
                        minSdk = Dep.Gradle.AppConfig.minSdkVersion
                    }
                    compileOptions {
                        sourceCompatibility(JavaVersion.VERSION_1_8)
                        targetCompatibility(JavaVersion.VERSION_1_8)
                    }
                    kotlinOptionsDF {
                        jvmTarget = "1.8"
                    }
                }
            }
        }
    }
}

fun Project.isAndroidLibrary(): Boolean = hasProperty("android")

fun Project.isAppModule(): Boolean = name == "app"

fun Project.application(configure: Action<com.android.build.gradle.internal.dsl.BaseAppModuleExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

fun com.android.build.gradle.internal.dsl.BaseAppModuleExtension.kotlinOptionsApp(configure: Action<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions>): Unit =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)

fun Project.dynamicFeature(configure: Action<com.android.build.gradle.internal.dsl.DynamicFeatureExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

fun com.android.build.gradle.internal.dsl.DynamicFeatureExtension.kotlinOptionsDF(configure: Action<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions>): Unit =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)




tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
