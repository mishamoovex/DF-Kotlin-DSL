plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
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

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }

    buildFeatures {
        dataBinding = true
    }

    dynamicFeatures += setOf(":features:splash")

    buildTypes {
        getByName(Dep.Gradle.AppConfig.BuildTypeNames.release) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    //Desugaring to able to use Java8 time lib
    coreLibraryDesugaring(Dep.Gradle.Desugaring.lib)
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
    implementation(Dep.Jetpack.Navigation.dynamicFeature)
    //Network
    implementation(Dep.Network.Retrofit.lib)
    implementation(Dep.Network.Retrofit.jsonConverter)
    implementation(Dep.Network.OkHttp.lib)
    implementation(Dep.Network.OkHttp.loggingInterceptor)
    //Firebase
    implementation(Dep.Firebase.Analytics.lib)
    implementation(Dep.Firebase.Crashlytics.lib)
}
