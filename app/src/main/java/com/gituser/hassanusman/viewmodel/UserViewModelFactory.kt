package com.gituser.hassanusman.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.gituser.hassanusman.views.callback.UserClickCallback

class UserViewModelFactory(private val listener: UserClickCallback) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel2(listener) as T
    }
}