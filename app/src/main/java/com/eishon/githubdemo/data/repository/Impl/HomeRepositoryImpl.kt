package com.eishon.githubdemo.data.repository.Impl

import com.eishon.githubdemo.data.api.GithubService
import com.eishon.githubdemo.data.model.Repo
import com.eishon.githubdemo.data.repository.HomeRepository

class HomeRepositoryImpl(
    private val githubService: GithubService
) : HomeRepository {

    override suspend fun getRepositories(userName: String): List<Repo> {
        return githubService.getUserRepos(userName)
    }
}