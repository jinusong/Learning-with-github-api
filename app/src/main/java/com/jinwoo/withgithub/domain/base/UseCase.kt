package com.jinwoo.withgithub.domain.base

import io.reactivex.Flowable
import io.reactivex.Single

abstract class UseCase<T, E> {

    abstract fun createSingle(entity: T): Flowable<E>
}