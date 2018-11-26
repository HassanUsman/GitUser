package com.gituser.hassanusman.viewmodel

import android.arch.lifecycle.ViewModel
import com.gituser.hassanusman.providers.model.UserObserver
import com.gituser.hassanusman.views.callback.UserClickCallback

class UserViewModel2(private val listener: UserClickCallback) : ViewModel() {
    private val user: UserObserver? = null
//    val searchTextWatcher:TextWatcher
//    get() = object:TextWatcher{
//        override fun afterTextChanged(s: Editable?) {
//            user.search//To change body of created functions use File | Settings | File Templates.
//        }
//    }
}