package ua.gov.diia.demoapp.di

import androidx.fragment.app.Fragment
import ua.gov.diia.demoapp.DemoApplication

val Fragment.appComponent: ApplicationComponent
    get() = (requireActivity().applicationContext as DemoApplication).appComponent