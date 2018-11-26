package com.gituser.hassanusman.providers.repository

object GithubSearchProvider {

    fun provideGithubSearch(): GithubSearch {
        return GithubSearch(GithubApiService.create())
    }

}