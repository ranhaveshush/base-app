package com.example.baseapp.di

import com.example.baseapp.api.github.GitHubApi
import com.example.baseapp.api.github.GitHubClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideGithubClient(api: GitHubApi): GitHubClient = GitHubClient(api)

    @Provides
    @Singleton
    fun provideGitHubApi(): GitHubApi = GitHubApi()
}
