package com.example.baseapp.repository

import com.example.baseapp.api.GitHubApi
import com.example.baseapp.api.GitHubClient

class HomeRepository private constructor(private val client: GitHubClient) {
    suspend fun listRepos(username: String) = client.listRepos(username)

    companion object {
        fun create(client: GitHubClient = GitHubClient(GitHubApi)) = HomeRepository(client)
    }
}
