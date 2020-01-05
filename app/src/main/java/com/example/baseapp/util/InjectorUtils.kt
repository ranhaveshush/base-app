package com.example.baseapp.util

import com.example.baseapp.api.GitHubApi
import com.example.baseapp.api.GitHubClient
import com.example.baseapp.repository.HomeRepository
import com.example.baseapp.viewmodel.HomeViewModelFactory

object InjectorUtils {

    fun provideHomeViewModelFactory(): HomeViewModelFactory {
        return HomeViewModelFactory(getHomeRepository())
    }

    fun getHomeRepository(): HomeRepository {
        return HomeRepository.create(GitHubClient(GitHubApi))
    }
}
