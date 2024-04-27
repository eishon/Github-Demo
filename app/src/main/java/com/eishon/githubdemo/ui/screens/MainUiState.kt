package com.eishon.githubdemo.ui.screens

import com.eishon.githubdemo.data.model.Repo

data class MainUiState (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
    val data: List<Repo> = emptyList()
)