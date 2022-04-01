@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "DemoApp"
//application
include(":app")
//libs
include(":lib:lifecycle")
include(":lib:navigation")
include(":lib:recycler")
include(":lib:dateTimeDialog")
include(":lib:styles")
//features
include(":features:splashScreen")
include(":features:authorization")
