package com.eishon.githubdemo.ui.screens.home.data

import com.eishon.githubdemo.data.model.Repo

data class HomeUiState (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
    val data: List<Repo> = emptyList()
)