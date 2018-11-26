package com.gituser.hassanusman.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gituser.hassanusman.App
import com.gituser.hassanusman.R
import com.gituser.hassanusman.di.component.DaggerFragmentComponent
import com.gituser.hassanusman.di.component.FragmentComponent
import com.gituser.hassanusman.di.module.FragmentModule
import javax.inject.Inject

class MainFragment @Inject constructor() : Fragment() {
    lateinit var component: FragmentComponent

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initInjector()
        //initComponent()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main, container, false);
    }

    private fun initInjector() {
        component = DaggerFragmentComponent.builder()
                                           .applicationComponent(App.component)
                                           .fragmentModule(FragmentModule(this))
                                           .build()
        component.inject(this)
    }

   /* private fun initComponent() {
btn_main_click.setOnClickListener { view ->
            val message: String = et_main_message.text.toString()

            if (!TextUtils.isEmpty(message)) {
                makeSnackbar(rl_main, message).show()
            }
        }

    }*/
}
