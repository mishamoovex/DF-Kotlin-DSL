plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    implementation(Dep.AndroidX.UI.MaterialDesign.lib)
    testImplementation(TestDep.Junit.Version4.lib)
}