package com.example.baseapp.api

import com.example.baseapp.api.data.Repo
import com.example.baseapp.vo.Resource
import kotlinx.coroutines.flow.flow

class GitHubClient(private val api: GitHubApi) {

    suspend fun listRepos(username: String) = flow {
        emit(Resource.loading())

        val resource = try {
            val response = api.service.listRepos(username)
            if (response.isSuccessful) {
                val repos = response.body()
                Resource.success(repos!!)
            } else {
                Resource.error(response.message())
            }
        } catch (e: Exception) {
            Resource.error<List<Repo>>(e.message!!, e.cause)
        }

        emit(resource)
    }
}
