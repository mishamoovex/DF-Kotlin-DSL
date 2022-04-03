plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android{
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    //Kotlin
    implementation(Dep.Kotlin.Coroutines.lib)
    //AndroidX components
    implementation(Dep.AndroidX.UI.AppCompat.lib)
    implementation(Dep.AndroidX.UI.MaterialDesign.lib)
    //lifecycle
    implementation(Dep.Jetpack.Lifecycle.liveData)
    implementation(Dep.Jetpack.Lifecycle.viewModel)
    implementation(Dep.Jetpack.Lifecycle.compilerJava8)
    //Dependency Injection
    implementation(Dep.Dagger2.lib)
    kapt(Dep.Dagger2.kapt)
    //Navigation
    implementation(Dep.Jetpack.Navigation.lib)
    implementation(Dep.Jetpack.Navigation.ui)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}