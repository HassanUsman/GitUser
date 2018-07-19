package com.gituser.hassanusman.providers.model

import java.util.Observable

class UserObserver: Observable() {
    var name: String = ""
        set(value) {
            field = value
            setChangedAndNotify("name")
        }
    var followers: String = ""
        set(value) {
            field = value
            setChangedAndNotify("followers")
        }

    var following: String = ""
        set(value) {
            field = value
            setChangedAndNotify("following")
        }
    var avatar_url: String = ""
        set(value) {
            field = value
            setChangedAndNotify("avatar_url")
        }
    var searchUser: String = ""
        set(value) {
            field = value
            setChangedAndNotify("searchUser")
        }
    var visibleView: Boolean = false
        set(value) {
            field = value
            setChangedAndNotify("visibleView")
        }

    private fun setChangedAndNotify(field: Any)
    {
        setChanged()
        notifyObservers(field)
    }

}