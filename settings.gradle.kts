@file:Suppress("UnstableApiUsage")

include(":lib:bindings")

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
//features
include(":features:splashScreen")
