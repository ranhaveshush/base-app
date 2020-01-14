package com.example.baseapp.repository

import com.example.baseapp.api.GitHubClient

class HomeRepository(private val client: GitHubClient) {
    suspend fun listRepos(username: String) = client.listRepos(username)
}
