package com.example.crm.postgresql_rest.dao.users

import org.springframework.data.jpa.repository.query.Procedure
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : CrudRepository<UsersDao, Long> {
    fun findByLoginAndPassword(login: String, password: String): UsersDao?

    @Procedure(name = "deleteAcc")
    fun deleteAcc(@Param("uId") uId: Long)
}