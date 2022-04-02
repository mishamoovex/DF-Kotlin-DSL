package ua.gov.diia.demoapp

import android.app.Application
import ua.gov.diia.demoapp.di.DaggerApplicationComponent

class DemoApplication : Application(){

    val appComponent = DaggerApplicationComponent.create()
}