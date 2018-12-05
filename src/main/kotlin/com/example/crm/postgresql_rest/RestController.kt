package com.example.crm.postgresql_rest

import com.example.crm.postgresql_rest.dao.users.FindUser
import com.example.crm.postgresql_rest.dao.users.UsersDao
import com.example.crm.postgresql_rest.dao.users.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController {

    @Autowired
    lateinit var userRepo: UsersRepository

    @PostMapping("/save")
    fun save(@RequestBody user: UsersDao): UsersDao? {
        return try {
            userRepo.save(user)
            userRepo.findByLoginAndPassword(user.login, user.password)
        } catch (e: Exception) {
            null
        }
    }

    @PostMapping("/findUser")
    fun findUser(@RequestBody user: FindUser): UsersDao? {
        return try {
            userRepo.findByLoginAndPassword(user.login, user.password)
        } catch (e: Exception) {
            null
        }
    }
}