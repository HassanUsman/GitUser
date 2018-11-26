package com.gituser.hassanusman.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.PropertyChangeRegistry
import android.util.Log
import android.view.View
import com.gituser.hassanusman.BR
import com.gituser.hassanusman.providers.model.UserObserver
import com.gituser.hassanusman.providers.repository.GithubSearchProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class UserViewModel(private val userObserver: UserObserver) : Observer, BaseObservable() {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val propertyChangeRegistry = PropertyChangeRegistry()

    init {
        userObserver.addObserver(this)
    }

    override fun update(p0: Observable?, p1: Any?) {
        when (p1) {
            "name" -> notifyPropertyChanged(BR.name)
            "searchUser" -> notifyPropertyChanged(BR.searchUser)
            "avatar_url" -> notifyPropertyChanged(BR.avatar_url)
            "errorMsg" -> notifyPropertyChanged(BR.errorMsg)
            "setErrorMessage" -> notifyPropertyChanged(BR.setErrorMessage)
            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }
    }

    val name: String
        @Bindable get() {
            return userObserver.name
        }
    val followers: String
        @Bindable get() {
            return userObserver.followers
        }
    val following: String
        @Bindable get() {
            return userObserver.following
        }
    val avatar_url: String
        @Bindable get() {
            return userObserver.avatar_url
        }
    var searchUser: String
        @Bindable get() {
            return userObserver.searchUser
        }
        set(name){
            userObserver.searchUser = name
        }
    val visibleView: Boolean
        @Bindable get() {
            return userObserver.visibleView
        }
    val errorMsg: String
        @Bindable get() {
            return userObserver.errorMsg
        }
    val setErrorMessage: String
        @Bindable get() {
            return userObserver.setErrorMessage
        }


    fun onButtonClick(view: View) {
        Log.e("Hp","Clicked  "+ userObserver.searchUser)
        if(userObserver.searchUser.isNotEmpty()){
            val repository = GithubSearchProvider.provideGithubSearch()
            compositeDisposable.add(
                    repository.searchUser(userObserver.searchUser)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe({ result ->
                                Log.e("Result", "There are ${result}")
//                                binding.setVariable(BR.userInfo, result)
//                                binding.executePendingBindings()
                                //Glide.with(this).load(result.avatar_url)

                            }, { error ->
                                error.printStackTrace()
                            }))
        }else {
            userObserver.errorMsg = "Username is required"
            userObserver.setErrorMessage = "Username is required"
        }
    }
}