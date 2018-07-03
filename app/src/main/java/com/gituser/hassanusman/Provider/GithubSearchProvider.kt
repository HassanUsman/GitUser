package com.gituser.hassanusman.Provider

import com.gituser.hassanusman.Network.GithubApiService
import com.gituser.hassanusman.Network.GithubSearch

object GithubSearchProvider {

    fun provideGithubSearch(): GithubSearch {
        return GithubSearch(GithubApiService.Factory.create())
    }

}