plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}


dependencies {

    implementation(project(":app"))

    //Kotlin
    implementation(Dep.Kotlin.Coroutines.lib)
    //AndroidX components
    implementation(Dep.AndroidX.KtxExtension.lib)
    implementation(Dep.AndroidX.UI.AppCompat.lib)
    implementation(Dep.AndroidX.UI.MaterialDesign.lib)
    implementation(Dep.AndroidX.UI.ConstraintLayout.lib)
    //Dependency Injection
    implementation(Dep.Dagger2.lib)
    kapt(Dep.Dagger2.kapt)
    //Navigation
    implementation(Dep.Jetpack.Navigation.lib)
}