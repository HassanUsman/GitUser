package com.gituser.hassanusman.di.component

import android.content.Context
import com.gituser.hassanusman.views.MainActivity
import com.gituser.hassanusman.di.module.ActivityModule
import com.gituser.hassanusman.di.scope.ActivityContext
import com.gituser.hassanusman.di.scope.ActivityScope
import com.gituser.hassanusman.views.callback.DetailActivity
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class),
           modules = arrayOf(ActivityModule::class)
)
interface ActivityComponent {

    @ActivityContext
    fun getContext(): Context

    fun inject(mainActivity: MainActivity)
    fun inject(detailActivity: DetailActivity)

}