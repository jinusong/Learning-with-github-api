package com.jinwoo.withgithub.data.repository.user

import com.jinwoo.withgithub.data.datasource.user.UserDataSource
import com.jinwoo.withgithub.domain.entity.PersonEntity
import com.jinwoo.withgithub.domain.entity.ProfileEntity
import com.jinwoo.withgithub.domain.entity.RepoEntity
import com.jinwoo.withgithub.domain.mapper.PersonEntityMapper
import com.jinwoo.withgithub.domain.mapper.ProfileEntityMapper
import com.jinwoo.withgithub.domain.mapper.RepoEntityMapper
import com.jinwoo.withgithub.domain.repository.user.UserRepository
import io.reactivex.Flowable

class UserRepositoryImpl(val dataSource: UserDataSource): UserRepository {
    val repoMapper = RepoEntityMapper()

    val personMapper = PersonEntityMapper()

    val profileMapper = ProfileEntityMapper()

    override fun getUserRepoList(userName: String): Flowable<ArrayList<RepoEntity>>
            = dataSource.getRemoteUserRepoList(userName)
        .flatMap{
            val arrayList = ArrayList<RepoEntity>()
            Flowable.fromIterable(it).map {
                arrayList.add(repoMapper.mapToEntity(it))
                arrayList
            }
        }

    override fun getUserFollowerList(userName: String): Flowable<ArrayList<PersonEntity>>
            = dataSource.getRemoteUserFollowerList(userName)
            .flatMap {
                val arrayList = ArrayList<PersonEntity>()
                Flowable.fromIterable(it).map {
                    arrayList.add(personMapper.mapToEntity(it))
                    arrayList
                }
            }

    override fun getUserFollowingList(userName: String): Flowable<ArrayList<PersonEntity>>
            = dataSource.getRemoteUserFollowingList(userName)
        .flatMap {
            val arrayList = ArrayList<PersonEntity>()
            Flowable.fromIterable(it).map {
                arrayList.add(personMapper.mapToEntity(it))
                arrayList
            }
        }

    override fun getUserProfile(userName: String): Flowable<ProfileEntity>
            = dataSource.getRemoteUserProfile(userName)
        .map { profileMapper.mapToEntity(it) }
}