package com.eishon.githubdemo.ui.screens.home.data

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eishon.githubdemo.data.model.ApiResult
import com.eishon.githubdemo.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HomeViewModel @Inject constructor(
    @Named("io_dispatcher") private val dispatcher: CoroutineDispatcher,
    private val repository: HomeRepository
) : ViewModel() {

    val uiState: MutableState<HomeUiState> = mutableStateOf(HomeUiState())

    init {
        getUserRepositories("eishon")
    }

    @VisibleForTesting
    fun getUserRepositories(userName: String) {
        viewModelScope.launch(dispatcher) {
            uiState.value = HomeUiState(isLoading = true)
            when (val reposResult = repository.getRepositories(userName)) {
                is ApiResult.Success -> {
                    uiState.value = HomeUiState(
                        isLoading = false,
                        data = reposResult.data
                    )
                }

                is ApiResult.Failure -> {
                    uiState.value = HomeUiState(
                        isLoading = false,
                        isError = true,
                        errorMessage = reposResult.exception.message ?: "An error occurred"
                    )
                }
            }

        }
    }
}