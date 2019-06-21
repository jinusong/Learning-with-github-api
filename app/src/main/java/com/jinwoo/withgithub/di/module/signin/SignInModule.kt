package com.jinwoo.withgithub.di.module.signin

import com.jinwoo.withgithub.data.datasource.AuthDataSource
import com.jinwoo.withgithub.data.datasource.AuthDataSourceImpl
import com.jinwoo.withgithub.data.local.LocalStorage
import com.jinwoo.withgithub.data.remote.client.AuthApiClient
import com.jinwoo.withgithub.data.local.AuthLocal
import com.jinwoo.withgithub.data.remote.AuthRemote
import com.jinwoo.withgithub.data.repository.AuthRepositoryImpl
import com.jinwoo.withgithub.di.scope.ActivityScope
import com.jinwoo.withgithub.domain.repository.auth.AuthRepository
import com.jinwoo.withgithub.domain.usecase.GetAuthUseCase
import com.jinwoo.withgithub.presentation.mapper.AuthMapper
import com.jinwoo.withgithub.presentation.signin.SignInContract
import com.jinwoo.withgithub.presentation.signin.SignInPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class SignInModule {

    @ActivityScope
    @Provides
    fun provideAuthRemote(authApiClient: AuthApiClient): AuthRemote =
        AuthRemote(authApiClient)

    @ActivityScope
    @Provides
    fun provideAuthLocal(localStorage: LocalStorage): AuthLocal =
        AuthLocal(localStorage)

    @ActivityScope
    @Provides
    fun provideAuthDataSource(remote: AuthRemote, local: AuthLocal): AuthDataSource = AuthDataSourceImpl(remote, local)

    @ActivityScope
    @Provides
    fun provideAuthRepository(authDataSource: AuthDataSource): AuthRepository
            = AuthRepositoryImpl(authDataSource)

    @ActivityScope
    @Provides
    fun provideAuthUseCase(repository: AuthRepository): GetAuthUseCase
            = GetAuthUseCase(repository)

    @ActivityScope
    @Provides
    fun provideAuthMapper(): AuthMapper
            = AuthMapper()

    @ActivityScope
    @Provides
    fun provideSignInPresenter(authUseCase: GetAuthUseCase, authMapper: AuthMapper, composite: CompositeDisposable)
            : SignInContract.Presenter = SignInPresenter(authUseCase, authMapper, composite)
}