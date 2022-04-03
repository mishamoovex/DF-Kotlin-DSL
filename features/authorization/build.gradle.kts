plugins {
    id("com.android.dynamic-feature")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {

    compileSdk = Dep.Gradle.AppConfig.compileSdkVersion

    defaultConfig {
        minSdk = Dep.Gradle.AppConfig.minSdkVersion
        testInstrumentationRunner = TestDep.testRunner
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {


    implementation(project(":app"))

    //Kotlin
    implementation(Dep.Kotlin.Coroutines.lib)
    //AndroidX components
    implementation(Dep.AndroidX.UI.AppCompat.lib)
    implementation(Dep.AndroidX.UI.MaterialDesign.lib)
    //lifecycle
//    implementation(Dep.Jetpack.Lifecycle.liveData)
//    implementation(Dep.Jetpack.Lifecycle.viewModel)
//    kapt(Dep.Jetpack.Lifecycle.kapt)
    //Dependency Injection
    implementation(Dep.Jetpack.Dagger2.lib)
    kapt(Dep.Jetpack.Dagger2.kapt)
    //Navigation
    implementation(Dep.Jetpack.Navigation.lib)
    //Firebase
    implementation(Dep.Firebase.AuthEmail.lib)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}