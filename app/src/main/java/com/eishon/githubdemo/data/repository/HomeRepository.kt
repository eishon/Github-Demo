package com.eishon.githubdemo.data.repository

import com.eishon.githubdemo.data.model.Repo

interface HomeRepository {

    suspend fun getRepositories(userName:String): List<Repo>
}