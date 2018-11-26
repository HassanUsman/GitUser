package com.gituser.hassanusman.di.module

import android.app.Activity
import android.content.Context
import com.gituser.hassanusman.di.scope.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor(private val activity: Activity) {

    @Provides
    internal fun provideActivity(): Activity = activity

    @Provides
    @ActivityContext
    internal fun provideActivityContext(): Context = activity
}