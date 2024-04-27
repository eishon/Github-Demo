package com.eishon.githubdemo.data.api

import com.eishon.githubdemo.data.model.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {

    @GET("users/{user}/repos")
    suspend fun getUserRepos(@Path("user") user: String): List<Repo>

}