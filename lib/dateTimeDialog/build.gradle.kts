plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android{

    compileSdk = Dep.Gradle.AppConfig.compileSdkVersion

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    defaultConfig {
        multiDexEnabled = true
    }
}

dependencies {

    implementation(Dep.Kotlin.Coroutines.lib)
    implementation(Dep.AndroidX.UI.AppCompat.lib)
    implementation(Dep.Gradle.Desugaring.lib)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}