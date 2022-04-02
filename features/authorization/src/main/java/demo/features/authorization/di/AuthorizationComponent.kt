package demo.features.authorization.di

import dagger.Component
import demo.features.authorization.presentation.method.SelectAuthMethodF
import ua.gov.diia.demoapp.di.ApplicationComponent
import ua.gov.diia.demoapp.di.ModuleScope

@ModuleScope
@Component(
    dependencies = [
        ApplicationComponent::class
    ]
)
internal interface AuthorizationComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: ApplicationComponent): AuthorizationComponent
    }

    fun inject(fragment: SelectAuthMethodF)
}