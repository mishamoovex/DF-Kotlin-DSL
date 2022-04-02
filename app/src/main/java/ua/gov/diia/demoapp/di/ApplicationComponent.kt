package ua.gov.diia.demoapp.di

import dagger.Component
import ua.gov.diia.demoapp.di.module.NetworkModule
import ua.gov.diia.demoapp.presentation.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

}