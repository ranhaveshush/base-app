package com.example.baseapp.util

import com.example.baseapp.api.github.GitHubApi
import com.example.baseapp.api.github.GitHubClient
import com.example.baseapp.repository.HomeRepository
import com.example.baseapp.viewmodel.HomeViewModelFactory

object InjectorUtils {

    fun provideHomeViewModelFactory() = HomeViewModelFactory(getHomeRepository())

    fun getHomeRepository() = HomeRepository(getGitHubClient())

    private fun getGitHubClient() = GitHubClient(GitHubApi)
}
