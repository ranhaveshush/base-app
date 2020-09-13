package com.example.baseapp.repository

import com.example.baseapp.api.EmptyApiResponse
import com.example.baseapp.api.ErrorApiResponse
import com.example.baseapp.api.SuccessApiResponse
import com.example.baseapp.api.github.GitHubClient
import com.example.baseapp.vo.Repo
import com.example.baseapp.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository @Inject constructor(private val client: GitHubClient) {

    suspend fun listRepos(username: String): Flow<Resource<List<Repo>>> = flow {
        emit(Resource.loading())

        val resource = try {
            when (val apiResponse = client.listRepos(username)) {
                is SuccessApiResponse -> Resource.success(apiResponse.data)
                is EmptyApiResponse -> Resource.empty()
                is ErrorApiResponse -> Resource.error(apiResponse.message)
            }
        } catch (e: Exception) {
            Resource.error<List<Repo>>(e.message!!, e.cause)
        }

        emit(resource)
    }
}
