package com.example.baseapp.api.github

import com.example.baseapp.api.ApiResponse
import com.example.baseapp.vo.Repo

class GitHubClient(private val api: GitHubApi) {

    suspend fun listRepos(username: String): ApiResponse<List<Repo>> {
        val response = api.service.listRepos(username)
        return ApiResponse.create(response)
    }
}
