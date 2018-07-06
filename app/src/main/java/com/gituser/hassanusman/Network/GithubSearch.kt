package com.gituser.hassanusman.Network

import com.gituser.hassanusman.Model.Result
import com.gituser.hassanusman.Model.Result2
import com.gituser.hassanusman.Model.User
import com.gituser.hassanusman.Model.userInfo

/**
 * Repository method to access search functionality of the api service
 */
class GithubSearch(val apiService: GithubApiService) {

    fun searchUsers(location: String, language: String): io.reactivex.Observable<Result> {
        return apiService.search(query = "location:$location language:$language")
    }

    fun searchUser(userName: String): io.reactivex.Observable<userInfo> {
        return apiService.user("$userName")
    }

}