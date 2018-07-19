package com.gituser.hassanusman.di.component

import android.app.Application
import android.content.Context
import com.gituser.hassanusman.di.module.ApplicationModule
import com.gituser.hassanusman.di.scope.ApplicationContext
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    @ApplicationContext
    fun getContext(): Context

    fun inject(application: Application)
}