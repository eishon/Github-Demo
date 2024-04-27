package com.eishon.githubdemo.ui.screens

import com.eishon.githubdemo.data.model.Repo

interface MainRepository {

    suspend fun getRepositories(userName:String): List<Repo>
}