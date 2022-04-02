package demo.features.authorization.di

import demo.features.authorization.presentation.method.SelectAuthMethodF
import ua.gov.diia.demoapp.di.appComponent

internal fun SelectAuthMethodF.injectGraph() {
    DaggerAuthorizationComponent.factory().create(appComponent).inject(this)
}
