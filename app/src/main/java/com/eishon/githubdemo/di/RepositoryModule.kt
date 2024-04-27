package com.eishon.githubdemo.di

import com.eishon.githubdemo.ui.screens.MainRepository
import com.eishon.githubdemo.ui.screens.MainRepositoryImpl
import com.eishon.githubdemo.data.api.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(githubService: GithubService):MainRepository = MainRepositoryImpl(githubService)

}