plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android{
    compileSdk = Dep.Gradle.AppConfig.compileSdkVersion
}

dependencies {

    implementation(Dep.Kotlin.Coroutines.lib)
    implementation(Dep.Jetpack.Navigation.lib)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}