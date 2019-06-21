package com.jinwoo.withgithub

import com.jinwoo.withgithub.presentation.signin.SignInContract
import com.jinwoo.withgithub.presentation.signin.SignInPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class SignInUnitTest {
    @Mock
    lateinit var presenter: SignInContract.Presenter

    @Mock
    lateinit var view: SignInContract.View

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testLoadWebView() {
        presenter.loadWebView(BuildConfig.GITHUB_CLIENT_ID)
    }

    @Test
    fun testToast() {
        view.createToast("hi")
    }
}