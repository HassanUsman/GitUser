package com.gituser.hassanusman.di.module

import android.app.Application
import android.content.Context
import com.gituser.hassanusman.di.scope.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule constructor(private val application: Application) {

    @Provides
    internal fun provideApplication(): Application = application

    @Provides
    @ApplicationContext
    internal fun provideApplicationContext(): Context = application
}