object TestDep {

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"

    object Coroutines {
        const val lib =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Dep.Kotlin.Coroutines.version}"
    }
}