package com.jinwoo.withgithub.domain.mapper

import com.jinwoo.withgithub.data.entity.*
import com.jinwoo.withgithub.domain.entity.PersonEntity

class PersonEntityMapper {
    fun mapToEntity(data: PersonData): PersonEntity = PersonEntity(id = data.id)
}