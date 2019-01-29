package com.example.crm.postgresql_rest.dao.users

/**
 * Created by haimin-a on 05.12.2018.
 */

data class FindUser(val login: String, val password: String)

data class UserId(val id: Long, val error: Long = 1)