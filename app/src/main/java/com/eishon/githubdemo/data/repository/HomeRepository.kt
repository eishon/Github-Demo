package com.eishon.githubdemo.data.repository

import com.eishon.githubdemo.data.model.Repo
import com.eishon.githubdemo.data.model.ApiResult

interface HomeRepository {

    suspend fun getRepositories(userName: String): ApiResult<List<Repo>>
}