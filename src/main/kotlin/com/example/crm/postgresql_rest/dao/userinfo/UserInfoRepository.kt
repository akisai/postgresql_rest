package com.example.crm.postgresql_rest.dao.userinfo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserInfoRepository : CrudRepository<UserInfoDao, Long> {
    fun findByUserId(user_id: Long): UserInfoDao?
}