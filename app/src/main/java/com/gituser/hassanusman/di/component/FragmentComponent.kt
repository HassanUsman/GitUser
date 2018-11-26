package com.gituser.hassanusman.di.component

import android.content.Context
import com.gituser.hassanusman.di.module.FragmentModule
import com.gituser.hassanusman.di.scope.ActivityContext
import com.gituser.hassanusman.di.scope.FragmentScope
import com.gituser.hassanusman.views.MainFragment
import dagger.Component

@FragmentScope
@Component(dependencies = arrayOf(ApplicationComponent::class),
           modules = arrayOf(FragmentModule::class)
)
interface FragmentComponent {

    @ActivityContext
    fun getContext(): Context

    fun inject(mainFragment: MainFragment)
}