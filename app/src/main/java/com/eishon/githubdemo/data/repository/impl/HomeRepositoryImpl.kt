package com.eishon.githubdemo.data.repository.impl

import com.eishon.githubdemo.data.api.GithubService
import com.eishon.githubdemo.data.model.Repo
import com.eishon.githubdemo.data.model.ApiResult
import com.eishon.githubdemo.data.repository.HomeRepository

class HomeRepositoryImpl(
    private val githubService: GithubService
) : HomeRepository {
    override suspend fun getRepositories(userName: String): ApiResult<List<Repo>> {
        return try {
            val repos = githubService.getUserRepos(userName)
            ApiResult.Success(repos)
        } catch (e: Exception) {
            ApiResult.Failure(e)
        }
    }
}