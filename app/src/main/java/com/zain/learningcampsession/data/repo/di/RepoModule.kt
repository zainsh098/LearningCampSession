package com.zain.learningcampsession.data.repo.di

// Created by Zain Shakoor
// on 6/13/2025


import com.zain.learningcampsession.data.repo.PostRepoImpl
import com.zain.learningcampsession.data.repo.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPostRepository(
        postRepoImpl: PostRepoImpl
    ): PostRepository
}
