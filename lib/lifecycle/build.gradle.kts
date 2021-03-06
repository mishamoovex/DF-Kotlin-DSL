plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {

    implementation(Dep.Jetpack.Lifecycle.liveData)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}