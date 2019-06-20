package com.jinwoo.withgithub.domain.base

interface Mapper<in T, E>{
    fun mapFrom(from: T): E
}