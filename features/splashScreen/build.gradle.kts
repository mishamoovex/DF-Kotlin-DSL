plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android{
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(":lib:styles"))
    implementation(project(":lib:lifecycle"))
    implementation(project(":lib:navigation"))

    //Kotlin
    implementation(Dep.Kotlin.Coroutines.lib)
    //AndroidX components
    implementation(Dep.AndroidX.UI.AppCompat.lib)
    implementation(Dep.AndroidX.UI.MaterialDesign.lib)
    //lifecycle
    implementation(Dep.Jetpack.Lifecycle.liveData)
    implementation(Dep.Jetpack.Lifecycle.viewModel)
    implementation(Dep.Jetpack.Lifecycle.compilerJava8)
    //Hilt
    implementation(Dep.Jetpack.Hilt.lib)
    implementation(Dep.Jetpack.Hilt.navigation)
    kapt(Dep.Jetpack.Hilt.kapt)
    //Navigation
    implementation(Dep.Jetpack.Navigation.lib)
    implementation(Dep.Jetpack.Navigation.ui)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}