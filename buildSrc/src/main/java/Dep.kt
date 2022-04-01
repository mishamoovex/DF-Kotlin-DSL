object Dep {

    object Gradle {
        const val version = "7.1.2"

        object AppConfig {
            const val compileSdkVersion = 32
            const val applicationId = "ua.gov.diia.demoapp"
            const val minSdkVersion = 24
            const val targetSdkVersion = 32
            const val versionCode = 1
            const val versionName = "1.0"

            object BuildTypeNames {
                const val release = "release"
                const val debug = "debug"
            }
        }

        /**
         * This dependency require additional setups
         *
         * compileOptions {
         *      isCoreLibraryDesugaringEnabled = true
         *      sourceCompatibility(JavaVersion.VERSION_1_8)
         *      targetCompatibility(JavaVersion.VERSION_1_8)
         *  }
         */
        object Desugaring {
            private const val version = "1.1.5"
            const val lib = "com.android.tools:desugar_jdk_libs:$version"
        }
    }

    object Kotlin {
        const val version = "1.6.10"

        object Coroutines {
            const val version = "1.6.0"
            const val lib = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }
    }

    object AndroidX {

        object KtxExtension {
            private const val version = "1.7.0"
            const val lib = "androidx.core:core-ktx:$version"
        }

        object ScreenComponent {

            object Fragment {
                private const val version = "1.4.1"
                const val lib = "androidx.fragment:fragment-ktx:$version"
            }

            object Activity {
                private const val version = "1.4.0"
                const val lib = "androidx.activity:activity-ktx:$version"
            }
        }

        object UI {

            object AppCompat {
                private const val version = "1.4.1"
                const val lib = "androidx.appcompat:appcompat:$version"
            }

            object MaterialDesign {
                private const val version = "1.5.0"
                const val lib = "com.google.android.material:material:$version"
            }

            object ConstraintLayout {
                private const val version = "2.1.3"
                const val lib = "androidx.constraintlayout:constraintlayout:$version"
            }
        }
    }

    object Jetpack {

        object Lifecycle {
            private const val version = "2.4.1"

            const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val compilerJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
        }

        object Navigation {
            private const val version = "2.4.1"

            const val lib = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val dynamicFeature =
                "androidx.navigation:navigation-dynamic-features-fragment:$version"

            /**
             * This dependency requires additional plugin (androidx.navigation.safeargs.kotlin)
             */
            object SafeArgs {
                const val gradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
            }
        }

        object Paging {
            private const val version = "3.1.1"
            const val lib = "androidx.paging:paging-runtime:$version"
        }

        /**
         * This dependency requires additional plugins:
         *       'kotlin-kapt'
         */
        object Room {
            private const val versionRoom = "2.2.6"
            private const val versionPaging = "2.5.0-alpha01"

            const val lib = "androidx.room:room-runtime:$versionRoom"
            const val coroutines = "androidx.room:room-ktx:$versionRoom"
            const val paging = "androidx.room:room-paging:$versionPaging"
            const val kapt = "androidx.room:room-compiler:$versionRoom"
        }

        object WorkManager {
            private const val version = "2.7.1"
            const val lib = "androidx.work:work-runtime-ktx:$version"
        }

        /**
         * This dependency requires additional plugins:
         *       'kotlin-kapt'
         *       'dagger.hilt.android.plugin'
         */
        object Hilt {
            private const val hiltVersion = "2.38.1"
            private const val hiltNavigationVersion = "1.0.0"

            const val lib = "com.google.dagger:hilt-android:$hiltVersion"
            const val navigation = "androidx.hilt:hilt-navigation-fragment:$hiltNavigationVersion"
            const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
            const val kapt = "com.google.dagger:hilt-compiler:$hiltVersion"
        }

    }

    object Network {

        object Retrofit {
            private const val version = "2.9.0"

            const val lib = "com.squareup.retrofit2:converter-gson:$version"
            const val jsonConverter = "com.squareup.retrofit2:retrofit:$version"
        }

        object OkHttp {
            private const val version = "4.9.3"

            const val lib = "com.squareup.okhttp3:okhttp:$version"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        }
    }

    object Firebase {
        private const val versionGradlePlugin = "4.3.10"
        const val gradlePlugin = "com.google.gms:google-services:$versionGradlePlugin"

        /**
         * Requires GooglePlay app level plugin id(com.google.gms.google-services)
         */
        object Analytics{
            private const val version = "20.1.2"
            const val lib = "com.google.firebase:firebase-analytics-ktx:$version"
        }

        /**
         * Requires app level plugin id(com.google.firebase.crashlytics)
         */
        object Crashlytics{
            private const val versionLib = "18.2.9"
            private const val versionGradlePlugin = "2.8.1"
            const val lib = "com.google.firebase:firebase-crashlytics-ktx:$versionLib"
            const val gradlePlugin = "com.google.firebase:firebase-crashlytics-gradle:$versionGradlePlugin"
        }

        object AuthEmail {
            private const val version = "21.0.3"
            const val lib = "com.google.firebase:firebase-auth-ktx:$version"
        }
    }

}