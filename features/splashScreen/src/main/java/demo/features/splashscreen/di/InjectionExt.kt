package demo.features.splashscreen.di

import demo.features.splashscreen.presentation.SplashF
import ua.gov.diia.demoapp.di.appComponent

internal fun SplashF.injectGraph() {
    DaggerSplashComponent.factory().create(appComponent).inject(this)
}