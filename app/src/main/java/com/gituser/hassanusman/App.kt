package com.gituser.hassanusman

import android.app.Application
import com.gituser.hassanusman.di.component.ApplicationComponent
import javax.inject.Inject


class App : Application() {

    companion object {
        lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        //component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }
}