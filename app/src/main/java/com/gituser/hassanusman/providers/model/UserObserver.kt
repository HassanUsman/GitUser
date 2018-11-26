package com.gituser.hassanusman.providers.model

import android.databinding.PropertyChangeRegistry
import java.util.*

class UserObserver: Observable(){

    private val  pcr = PropertyChangeRegistry()
    var name: String = ""
        set(value) {
            field = value
            setChangedAndNotify("name")
            //pcr.notifyChange(this, BR.name)

        }
    var followers: String = ""
        set(value) {
            field = value
            setChangedAndNotify("followers")
            //pcr.notifyChange(this, BR.followers)

        }

    var following: String = ""
        set(value) {
            field = value
            setChangedAndNotify("following")
            //pcr.notifyChange(this, BR.following)

        }
    var avatar_url: String = ""
        set(value) {
            field = value
            setChangedAndNotify("avatar_url")
            //pcr.notifyChange(this, BR.avatar_url)

        }
    var searchUser: String = ""
        set(value) {
            field = value
            setChangedAndNotify("searchUser")
            //pcr.notifyChange(this, BR.searchUser)
        }
    var visibleView: Boolean = false
        set(value) {
            field = value
            setChangedAndNotify("visibleView")
            //pcr.notifyChange(this, BR.visibleView)

        }
    var errorMsg: String = ""
    set(value) {
        field = value
        setChangedAndNotify("errorMsg")
        //pcr.notifyChange(this, BR.searchUser)
    }
    var setErrorMessage: String = ""
        set(value) {
            field = value
            setChangedAndNotify("setErrorMessage")
        }

    private fun setChangedAndNotify(field: Any)
    {
        setChanged()
        notifyObservers(field)
    }
//    override fun removeOnPropertyChangedCallback(callback: android.databinding.Observable.OnPropertyChangedCallback?) {
//        pcr.remove(callback)
//    }
//
//    override fun addOnPropertyChangedCallback(callback: android.databinding.Observable.OnPropertyChangedCallback?) {
//        pcr.add(callback)
//    }


}