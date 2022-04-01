plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {

    defaultConfig {
        applicationId = Dep.Gradle.AppConfig.applicationId
        versionCode = Dep.Gradle.AppConfig.versionCode
        versionName = Dep.Gradle.AppConfig.versionName
    }

    buildTypes {
        getByName(Dep.Gradle.AppConfig.BuildTypeNames.release) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(":lib:styles"))

    implementation(project(":features:splashScreen"))
    implementation(project(":features:authorization"))

    //Kotlin
    implementation(Dep.Kotlin.Coroutines.lib)
    //AndroidX components
    implementation(Dep.AndroidX.KtxExtension.lib)
    implementation(Dep.AndroidX.ScreenComponent.Fragment.lib)
    implementation(Dep.AndroidX.UI.AppCompat.lib)
    implementation(Dep.AndroidX.UI.MaterialDesign.lib)
    implementation(Dep.AndroidX.UI.ConstraintLayout.lib)
    //lifecycle
    implementation(Dep.Jetpack.Lifecycle.liveData)
    implementation(Dep.Jetpack.Lifecycle.viewModel)
    implementation(Dep.Jetpack.Lifecycle.compilerJava8)
    //Hilt
    implementation(Dep.Jetpack.Hilt.lib)
    implementation(Dep.Jetpack.Hilt.navigation)
    kapt(Dep.Jetpack.Hilt.kapt)
    //Room
    implementation(Dep.Jetpack.Room.lib)
    implementation(Dep.Jetpack.Room.coroutines)
    implementation(Dep.Jetpack.Room.paging)
    kapt(Dep.Jetpack.Room.kapt)
    //Navigation
    implementation(Dep.Jetpack.Navigation.lib)
    implementation(Dep.Jetpack.Navigation.ui)
    implementation(Dep.Jetpack.Navigation.dynamicFeature)
    //Paging
    implementation(Dep.Jetpack.Paging.lib)
    //Work manager
    implementation(Dep.Jetpack.WorkManager.lib)
    //Network
    implementation(Dep.Network.Retrofit.lib)
    implementation(Dep.Network.Retrofit.jsonConverter)
    implementation(Dep.Network.OkHttp.lib)
    implementation(Dep.Network.OkHttp.loggingInterceptor)
    //Firebase
    implementation(Dep.Firebase.Analytics.lib)
    implementation(Dep.Firebase.Crashlytics.lib)


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
