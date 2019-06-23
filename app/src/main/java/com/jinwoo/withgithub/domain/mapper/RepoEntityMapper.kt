package com.jinwoo.withgithub.domain.mapper

import com.jinwoo.withgithub.data.entity.*
import com.jinwoo.withgithub.domain.entity.RepoEntity

class RepoEntityMapper {
    val mapper = PersonEntityMapper()

    fun mapToEntity(data: RepoData): RepoEntity = RepoEntity(
        id = data.id,
        name = data.name,
        description = data.description,
        stargazersCount = data.stargazersCount,
        language = data.language,
        owner = mapper.mapToEntity(data.owner)
    )
}