plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    defaultConfig {
        applicationId = Dependency.AppConfig.applicationId
        versionCode = Dependency.AppConfig.versionCode
        versionName = Dependency.AppConfig.versionName
    }

    buildTypes {
        getByName(Dependency.AppConfig.BuildTypeNames.release) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    //Kotlin
    implementation(Dependency.Kotlin.Coroutines.lib)
    //AndroidX components
    implementation(Dependency.AndroidX.KtxExtension.lib)
    implementation(Dependency.AndroidX.ScreenComponent.Activity.lib)
    implementation(Dependency.AndroidX.ScreenComponent.Fragment.lib)
    implementation(Dependency.AndroidX.UI.AppCompat.lib)
    implementation(Dependency.AndroidX.UI.MaterialDesign.lib)
    implementation(Dependency.AndroidX.UI.ConstraintLayout.lib)
    //lifecycle
    implementation(Dependency.Jetpack.Lifecycle.liveData)
    implementation(Dependency.Jetpack.Lifecycle.viewModel)
    implementation(Dependency.Jetpack.Lifecycle.compilerJava8)
    //Hilt
    implementation(Dependency.Jetpack.Hilt.lib)
    implementation(Dependency.Jetpack.Hilt.navigation)
    kapt(Dependency.Jetpack.Hilt.kapt)
    //Room
    implementation(Dependency.Jetpack.Room.lib)
    implementation(Dependency.Jetpack.Room.coroutines)
    implementation(Dependency.Jetpack.Room.paging)
    kapt(Dependency.Jetpack.Room.kapt)
    //Navigation
    implementation(Dependency.Jetpack.Navigation.lib)
    implementation(Dependency.Jetpack.Navigation.ui)
    implementation(Dependency.Jetpack.Navigation.dynamicFeature)
    //Paging
    implementation(Dependency.Jetpack.Paging.lib)
    //Work manager
    implementation(Dependency.Jetpack.WorkManager.lib)
    //Network
    implementation(Dependency.Network.Retrofit.lib)
    implementation(Dependency.Network.Retrofit.jsonConverter)
    implementation(Dependency.Network.OkHttp.lib)
    implementation(Dependency.Network.OkHttp.loggingInterceptor)


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
