package com.eishon.githubdemo.ui.screens.home.data

import com.eishon.githubdemo.CoreTest
import com.eishon.githubdemo.data.model.ApiResult
import com.eishon.githubdemo.data.model.Repo
import com.eishon.githubdemo.data.repository.HomeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private val repository = mock(HomeRepository::class.java)

    private val dispatcher = UnconfinedTestDispatcher()

    private val sut = HomeViewModel(dispatcher, repository)

    @Test
    fun `should show data when api result is success`() = runTest {
        `when`(repository.getRepositories("eishon"))
            .thenReturn(
                ApiResult.Success(
                    listOf(
                        Repo("repo1"),
                        Repo("repo2")
                    )
                )
            )

        sut.getUserRepositories("eishon")

        assertEquals(2, sut.uiState.value.data.size)
    }

    @Test
    fun `should show error when api result is success`() = runTest {
        `when`(repository.getRepositories("eishon"))
            .thenReturn(
                ApiResult.Failure(
                    RuntimeException("An error occurred")
                )
            )

        sut.getUserRepositories("eishon")

        assertEquals(0, sut.uiState.value.data.size)
    }
}