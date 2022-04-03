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
include(":lib:recycler")
include(":lib:styles")
//features
include(":features:splashScreen")
include(":features:authorization")
