package com.jinwoo.withgithub.presentation.mapper

import com.jinwoo.withgithub.domain.base.Mapper
import com.jinwoo.withgithub.domain.entity.PersonEntity
import com.jinwoo.withgithub.presentation.entity.Person

class PersonMapper: Mapper<PersonEntity, Person> {

    override fun mapFrom(from: PersonEntity): Person = Person(id = from.id)
}