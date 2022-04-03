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
    compileSdk = Dep.Gradle.AppConfig.compileSdkVersion

    defaultConfig {
        applicationId = Dep.Gradle.AppConfig.applicationId
        minSdk = Dep.Gradle.AppConfig.minSdkVersion
        targetSdk = Dep.Gradle.AppConfig.targetSdkVersion
        versionCode = Dep.Gradle.AppConfig.versionCode
        versionName = Dep.Gradle.AppConfig.versionName
        testInstrumentationRunner = TestDep.testRunner
    }

    buildTypes {
        getByName(Dep.Gradle.AppConfig.BuildTypeNames.release) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
                "proguard-rules-dynamic-features.pro"
            )
        }
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
    dynamicFeatures += setOf(
        ":features:splashScreen",
        ":features:authorization"
    )
}

dependencies {

    implementation(project(":lib:styles"))

    //Kotlin
    implementation(Dep.Kotlin.Coroutines.lib)
    //AndroidX components
    implementation(Dep.AndroidX.UI.AppCompat.lib)
    implementation(Dep.AndroidX.UI.MaterialDesign.lib)
    implementation(Dep.AndroidX.UI.ConstraintLayout.lib)
    //Dependency Injection
    implementation(Dep.Jetpack.Dagger2.lib)
    kapt(Dep.Jetpack.Dagger2.kapt)
    //Navigation
    implementation(Dep.Jetpack.Navigation.lib)
    implementation(Dep.Jetpack.Navigation.ui)
    implementation(Dep.Jetpack.Navigation.dynamicFeature)
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
