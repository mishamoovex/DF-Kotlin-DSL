object TestDep {

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"

    object Coroutines {
        const val lib =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Dep.Kotlin.Coroutines.version}"
    }

    object Junit{

        object Version4{
            private const val version = "4.13.2"
            const val lib = "junit:junit:$version"
        }

        object Version5{

        }
    }
}