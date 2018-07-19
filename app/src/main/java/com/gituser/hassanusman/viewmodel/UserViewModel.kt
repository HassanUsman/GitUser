package com.gituser.hassanusman.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import android.view.View
import com.gituser.hassanusman.BR
import com.gituser.hassanusman.providers.model.UserObserver
import io.reactivex.disposables.CompositeDisposable
import java.util.*

class UserViewModel(private val userObserver: UserObserver) : Observer, BaseObservable() {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        userObserver.addObserver(this)
    }

    override fun update(p0: Observable?, p1: Any?) {
        if (p1 is String) {
            if (p1 == "name") {
                notifyPropertyChanged(BR.name)
            } else if (p1 == "avatar_url") {
                notifyPropertyChanged(BR.avatar_url)
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
    val searchUser: String
        @Bindable get() {
            return userObserver.searchUser
        }
    val visibleView: Boolean
        @Bindable get() {
            return userObserver.visibleView
        }


    fun onButtonClick(view: View) {
        Log.e("Hp","Clicked"+view)

//        if(view.text.isNotEmpty()){
//            compositeDisposable.add(
//                    repository.searchUser(etSearch.text.toString())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribeOn(Schedulers.io())
//                            .subscribe({ result ->
//                                Log.d("Result", "There are ${result}")
//                                binding.setVariable(BR.userInfo, result)
//                                binding.executePendingBindings()
//                                //Glide.with(this).load(result.avatar_url)
//
//                            }, { error ->
//                                error.printStackTrace()
//                            }))
//        }else
//            view.error = "Username is required"
    }
}