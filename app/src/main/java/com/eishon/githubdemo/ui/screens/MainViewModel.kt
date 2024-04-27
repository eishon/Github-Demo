package com.eishon.githubdemo.ui.screens

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    val uiState: MutableState<MainUiState> = mutableStateOf(MainUiState())

    fun getUserRepositories(userName: String) {
         viewModelScope.launch {
            try {
                val repos = repository.getRepositories(userName)
                uiState.value =MainUiState(data = repos)
            } catch (e: Exception) {
                // handle error
                Log.d("MainViewModel", "getUserRepositories: ${e.message}")
            }
         }
    }
}