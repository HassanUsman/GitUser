package com.gituser.hassanusman.providers.repository

import com.gituser.hassanusman.providers.model.Result
import com.gituser.hassanusman.providers.model.UserObserver

/**
 * Repository method to access search functionality of the api service
 */
class GithubSearch(val apiService: GithubApiService) {

    fun searchUsers(location: String, language: String): io.reactivex.Observable<Result> {
        return apiService.search(query = "location:$location language:$language")
    }

    fun searchUser(userName: String): io.reactivex.Observable<UserObserver> {
        return apiService.user("$userName")
    }

}