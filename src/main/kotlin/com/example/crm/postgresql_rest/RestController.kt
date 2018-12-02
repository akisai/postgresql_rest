package com.example.crm.postgresql_rest

import com.example.crm.postgresql_rest.dao.users.UsersDao
import com.example.crm.postgresql_rest.dao.users.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class RestController {

    @Autowired
    lateinit var userRepo: UsersRepository

    @GetMapping("/save/{login}/{password}")
    fun save(@PathVariable login: String, @PathVariable password: String): String {
        userRepo.save(UsersDao(login, password, LocalDate.now()))
        return "Done"
    }

    @RequestMapping("/findUser/{login}/{password}")
    fun findUser(@PathVariable login: String, @PathVariable password: String)
            = userRepo.findByLoginAndPassword(login, password) != null
}