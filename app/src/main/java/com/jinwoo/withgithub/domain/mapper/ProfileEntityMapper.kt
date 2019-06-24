package com.jinwoo.withgithub.domain.mapper

import com.jinwoo.withgithub.data.entity.*
import com.jinwoo.withgithub.domain.entity.PersonEntity
import com.jinwoo.withgithub.domain.entity.ProfileEntity

class ProfileEntityMapper {
    fun mapToEntity(data: ProfileData): ProfileEntity = ProfileEntity(
        name = data.name,
        company = data.company,
        blog = data.blog,
        bio = data.bio,
        followers = data.followers,
        following = data.following
    )
}