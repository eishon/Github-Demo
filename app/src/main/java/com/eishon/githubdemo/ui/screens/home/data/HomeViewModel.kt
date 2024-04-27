package com.eishon.githubdemo.ui.screens.home.data

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eishon.githubdemo.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    val uiState: MutableState<HomeUiState> = mutableStateOf(HomeUiState())

    init {
        getUserRepositories("eishon")
    }

    private fun getUserRepositories(userName: String) {
         viewModelScope.launch {
            try {
                val repos = repository.getRepositories(userName)
                uiState.value = HomeUiState(data = repos)
            } catch (e: Exception) {
                // handle error
                Log.d("MainViewModel", "getUserRepositories: ${e.message}")
            }
         }
    }
}