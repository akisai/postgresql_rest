package com.example.crm.postgresql_rest

import com.example.crm.postgresql_rest.dao.users.FindUser
import com.example.crm.postgresql_rest.dao.users.UsersDao
import com.example.crm.postgresql_rest.dao.users.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class RestController {

    @Autowired
    lateinit var userRepo: UsersRepository

    @PostMapping("/save")
    fun save(@RequestBody user: UsersDao): String {
        userRepo.save(user)
        return "Done"
    }

    @PostMapping("/findUser")
    fun findUser(@RequestBody user: FindUser)
            = userRepo.findByLoginAndPassword(user.login, user.password) != null
}