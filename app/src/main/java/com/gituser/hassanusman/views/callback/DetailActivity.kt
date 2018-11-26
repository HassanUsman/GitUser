package com.gituser.hassanusman.views.callback

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gituser.hassanusman.App
import com.gituser.hassanusman.R
import com.gituser.hassanusman.di.component.ActivityComponent
import com.gituser.hassanusman.di.component.DaggerActivityComponent
import com.gituser.hassanusman.di.module.ActivityModule
import com.gituser.hassanusman.views.MainFragment
import javax.inject.Inject


class DetailActivity : AppCompatActivity() {
    @Inject
    lateinit var fragment: MainFragment
    lateinit var component: ActivityComponent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initInjector()
    }
    private fun initInjector() {
        component = DaggerActivityComponent.builder()
                .applicationComponent(App.component)
                .activityModule(ActivityModule(this))
                .build()
        component.inject(this)
    }
}


/*
    private fun addButtonListener() {
        btn_main.setOnClickListener { view ->
            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fl_main, fragment, MainFragment::class.java.simpleName)
            fragmentTransaction.commit()
        }
    }
}*/