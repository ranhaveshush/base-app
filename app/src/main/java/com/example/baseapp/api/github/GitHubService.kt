package com.example.baseapp.api.github

import com.example.baseapp.vo.Repo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{username}/repos")
    suspend fun listRepos(@Path("username") username: String): Response<List<Repo>>
}
