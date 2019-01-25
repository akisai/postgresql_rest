package com.example.crm.postgresql_rest

import com.example.crm.postgresql_rest.dao.doctors.DoctorsInfo
import com.example.crm.postgresql_rest.dao.doctors.DoctorsRepository
import com.example.crm.postgresql_rest.dao.userinfo.FindInfoById
import com.example.crm.postgresql_rest.dao.userinfo.UserInfoDao
import com.example.crm.postgresql_rest.dao.userinfo.UserInfoRepository
import com.example.crm.postgresql_rest.dao.users.FindUser
import com.example.crm.postgresql_rest.dao.users.UsersDao
import com.example.crm.postgresql_rest.dao.users.UsersRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController {

    var logger = LoggerFactory.getLogger(com.example.crm.postgresql_rest.RestController::class.java)

    @Autowired
    lateinit var userRepo: UsersRepository

    @Autowired
    lateinit var userInfoRepo: UserInfoRepository

    @Autowired
    lateinit var doctorsRepo: DoctorsRepository


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

    @PostMapping("/updateInfo")
    fun updateInfo(@RequestBody userInfo: UserInfoDao): Boolean? {
        logger.info("start")
        return try {
            userInfoRepo.save(userInfo)
            true
        } catch (e: Exception) {
            null
        }
    }

    @GetMapping("/getDoctors")
    fun getDoctors(): ArrayList<DoctorsInfo> {
        return try {
            val doctorsInfo: ArrayList<DoctorsInfo> = ArrayList()
            val doctors = doctorsRepo.findAll()
            for (i in doctors) {
                if (i.available.toString().toBoolean()) {
                    val user = userInfoRepo.findByUserId(i.userId)
                    if (user != null) {
                        doctorsInfo.add(DoctorsInfo(user.name!!, user.surname!!, user.birthday!!, i.procedure!!, i.start!!, i.end!!))
                    }
                }
            }
            doctorsInfo
        } catch (e: Exception) {
            ArrayList()
        }
    }

    @PostMapping("/getProcedure")
    fun getProcedure() {

    }
}