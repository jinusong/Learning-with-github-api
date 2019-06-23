package com.jinwoo.withgithub.presentation.mapper

import com.jinwoo.withgithub.domain.base.Mapper
import com.jinwoo.withgithub.domain.entity.ProfileEntity
import com.jinwoo.withgithub.presentation.entity.Profile

class ProfileMapper: Mapper<ProfileEntity, Profile> {

    override fun mapFrom(from: ProfileEntity): Profile = Profile(
        name = from.name,
        company = from.company,
        blog = from.blog,
        bio = from.bio,
        followers = from.followers,
        following = from.following
    )
}