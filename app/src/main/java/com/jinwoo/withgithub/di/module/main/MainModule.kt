package com.jinwoo.withgithub.di.module.main

import com.jinwoo.withgithub.data.datasource.user.UserDataSource
import com.jinwoo.withgithub.data.datasource.user.UserDataSourceImpl
import com.jinwoo.withgithub.data.local.user.UserLocal
import com.jinwoo.withgithub.data.remote.client.ApiClient
import com.jinwoo.withgithub.data.remote.user.UserRemote
import com.jinwoo.withgithub.data.repository.user.UserRepositoryImpl
import com.jinwoo.withgithub.di.scope.ActivityScope
import com.jinwoo.withgithub.domain.repository.user.UserRepository
import com.jinwoo.withgithub.domain.usecase.GetUserFollowerListUseCase
import com.jinwoo.withgithub.domain.usecase.GetUserFollowingListUseCase
import com.jinwoo.withgithub.domain.usecase.GetUserProfileUseCase
import com.jinwoo.withgithub.domain.usecase.GetUserRepoListUseCase
import com.jinwoo.withgithub.presentation.main.MainContract
import com.jinwoo.withgithub.presentation.main.MainPresenter
import com.jinwoo.withgithub.presentation.mapper.PersonMapper
import com.jinwoo.withgithub.presentation.mapper.ProfileMapper
import com.jinwoo.withgithub.presentation.mapper.RepoMapper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MainModule {
    @ActivityScope
    @Provides
    fun provideUserRemote(apiClient: ApiClient): UserRemote = UserRemote(apiClient)

    @ActivityScope
    @Provides
    fun provideUserLocal(): UserLocal = UserLocal()

    @ActivityScope
    @Provides
    fun provideUserDataSource(remote: UserRemote, local: UserLocal): UserDataSource =
        UserDataSourceImpl(remote, local)

    @ActivityScope
    @Provides
    fun provideUserRepository(userDataSource: UserDataSource): UserRepository = UserRepositoryImpl(userDataSource)

    @ActivityScope
    @Provides
    fun provideGetUserRepoListUseCase(repository: UserRepository): GetUserRepoListUseCase
            = GetUserRepoListUseCase(repository)

    @ActivityScope
    @Provides
    fun provideGetUserFollowerListUseCase(repository: UserRepository): GetUserFollowerListUseCase
            = GetUserFollowerListUseCase(repository)

    @ActivityScope
    @Provides
    fun provideGetUserFollowingListUseCase(repository: UserRepository): GetUserFollowingListUseCase
            = GetUserFollowingListUseCase(repository)

    @ActivityScope
    @Provides
    fun provideGetUserProfileUseCase(repository: UserRepository): GetUserProfileUseCase
            = GetUserProfileUseCase(repository)

    @ActivityScope
    @Provides
    fun provideRepoMapper(): RepoMapper = RepoMapper()

    @ActivityScope
    @Provides
    fun providePersonMapper(): PersonMapper = PersonMapper()

    @ActivityScope
    @Provides
    fun provideProfileMapper(): ProfileMapper = ProfileMapper()

    @ActivityScope
    @Provides
    fun provideMainPresenter(repoUseCase: GetUserRepoListUseCase, followerListUseCase: GetUserFollowerListUseCase,
                             followingListUseCase: GetUserFollowingListUseCase, profileUseCase: GetUserProfileUseCase,
                             repoMapper: RepoMapper, personMapper: PersonMapper, profileMapper: ProfileMapper,
                             composite: CompositeDisposable): MainContract.Presenter
            = MainPresenter(repoUseCase, followerListUseCase, followingListUseCase, profileUseCase,
        repoMapper, personMapper, profileMapper, composite)
}