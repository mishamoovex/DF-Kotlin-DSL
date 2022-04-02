package demo.features.splashscreen.di

import dagger.Component
import demo.features.splashscreen.presentation.SplashF
import ua.gov.diia.demoapp.di.ApplicationComponent
import ua.gov.diia.demoapp.di.ModuleScope

@ModuleScope
@Component(
    dependencies = [
        ApplicationComponent::class
    ]
)
internal interface SplashComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: ApplicationComponent): SplashComponent
    }

    fun inject(fragment: SplashF)
}