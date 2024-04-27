package com.eishon.githubdemo.di

import com.eishon.githubdemo.data.repository.HomeRepository
import com.eishon.githubdemo.data.repository.Impl.HomeRepositoryImpl
import com.eishon.githubdemo.data.api.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(githubService: GithubService): HomeRepository = HomeRepositoryImpl(githubService)

}