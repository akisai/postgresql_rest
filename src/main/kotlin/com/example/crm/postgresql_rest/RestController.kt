package com.example.crm.postgresql_rest

import com.example.crm.postgresql_rest.dao.categories.CategoriesDao
import com.example.crm.postgresql_rest.dao.categories.CategoriesRepository
import com.example.crm.postgresql_rest.dao.categories.GetRules
import com.example.crm.postgresql_rest.dao.userinfo.FindInfoById
import com.example.crm.postgresql_rest.dao.userinfo.UserInfoDao
import com.example.crm.postgresql_rest.dao.userinfo.UserInfoRepository
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

    @Autowired
    lateinit var userInfoRepo: UserInfoRepository

    @Autowired
    lateinit var categoriesRepo: CategoriesRepository

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

    @PostMapping("/userInfo")
    fun findInfo(@RequestBody userInfo: FindInfoById): UserInfoDao? {
        return try {
            userInfoRepo.findByUserId(userInfo.user_id)
        } catch (e: Exception) {
            null
        }
    }

    @PostMapping("/getRules")
    fun getRules(@RequestBody category: GetRules): CategoriesDao? {
        return categoriesRepo.findByCategory(category.category)
        /*return try {
            categoriesRepo.findByCategory(category.category)
        } catch (e: Exception) {
            null
        }*/
    }

}