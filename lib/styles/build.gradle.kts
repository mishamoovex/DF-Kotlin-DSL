plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android{
    compileSdk = Dep.Gradle.AppConfig.compileSdkVersion
}

dependencies{
    implementation(Dep.AndroidX.UI.MaterialDesign.lib)
}