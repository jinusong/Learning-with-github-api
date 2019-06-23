package com.jinwoo.withgithub.presentation.mapper

import com.jinwoo.withgithub.domain.base.Mapper
import com.jinwoo.withgithub.domain.entity.RepoEntity
import com.jinwoo.withgithub.presentation.entity.Repo

class RepoMapper: Mapper<RepoEntity, Repo> {
    val mapper = PersonMapper()

    override fun mapFrom(from: RepoEntity): Repo = Repo(
        id = from.id,
        name = from.name,
        description = from.description,
        stargazersCount = from.stargazersCount,
        language = from.language,
        owner = mapper.mapFrom(from.owner)
    )
}