plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android{
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(Dep.Jetpack.Lifecycle.lifecycle)
}