package com.eishon.githubdemo.ui.screens

import com.eishon.githubdemo.data.api.GithubService
import com.eishon.githubdemo.data.model.Repo

class MainRepositoryImpl(
    private val githubService: GithubService
) :MainRepository{

    override suspend fun getRepositories(userName: String): List<Repo> {
        return githubService.getUserRepos(userName)
    }
}