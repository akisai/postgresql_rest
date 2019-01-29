package com.example.crm.postgresql_rest

import com.example.crm.postgresql_rest.dao.doctors.DoctorsInfo
import com.example.crm.postgresql_rest.dao.doctors.DoctorsRepository
import com.example.crm.postgresql_rest.dao.doctors.FindTimeInfo
import com.example.crm.postgresql_rest.dao.doctors.TimeInfo
import com.example.crm.postgresql_rest.dao.procedure.ProcedureInfo
import com.example.crm.postgresql_rest.dao.procedure.ProcedureRepository
import com.example.crm.postgresql_rest.dao.tasks.*
import com.example.crm.postgresql_rest.dao.userinfo.FindInfoById
import com.example.crm.postgresql_rest.dao.userinfo.UserInfoDao
import com.example.crm.postgresql_rest.dao.userinfo.UserInfoRepository
import com.example.crm.postgresql_rest.dao.users.FindUser
import com.example.crm.postgresql_rest.dao.users.UserId
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

    @Autowired
    lateinit var procedureRepo: ProcedureRepository

    @Autowired
    lateinit var tasksRepo: TasksRepository


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
    fun getDoctors(): ArrayList<DoctorsInfo>? {
        return try {
            val doctorsInfo: ArrayList<DoctorsInfo> = ArrayList()
            val doctors = doctorsRepo.findAll()
            for (i in doctors) {
                if (i.available!!) {
                    val user = userInfoRepo.findByUserId(i.userId)
                    if (user != null) {
                        doctorsInfo.add(DoctorsInfo(user.name!!, user.surname!!, user.birthday!!, i.procedure!!, i.start!!, i.end!!, i.userId, i.id))
                    }
                }
            }
            doctorsInfo
        } catch (e: Exception) {
            null
        }
    }

    @GetMapping("/getProcedure")
    fun getProcedure(): ArrayList<ProcedureInfo>? {
        return try {
            val procedureInfo: ArrayList<ProcedureInfo> = ArrayList()
            val procedure = procedureRepo.findAll()
            val doc = doctorsRepo.findAll()
            for (p in procedure) {
                var str = "{"
                for (d in doc) {
                    if (d.available!!)
                        if (d.procedure!!.contains(p.id.toString())) {
                            str += d.id.toString() + ","
                        }
                }
                procedureInfo.add(ProcedureInfo(p.id, p.name!!, p.description!!, p.cost!!, str.dropLast(1) + "}"))
            }
            procedureInfo
        } catch (e: Exception) {
            null
        }
    }

    @PostMapping("/getTime")
    fun getTime(@RequestBody findTimeInfo: FindTimeInfo): TimeInfo {
        val doc = doctorsRepo.findById(findTimeInfo.id).get()
        return TimeInfo(doc.id, doc.start!!, doc.end!!)
    }

    @PostMapping("/getRasp")
    fun getRasp(@RequestBody findTasks: FindTasks): Array<TasksDao>? {
        return try {
            tasksRepo.findAllByDoctorIdAndDate(findTasks.doctorId, findTasks.date)!!.toTypedArray()
        } catch (e: Exception) {
            null
        }
    }

    @PostMapping("/saveRasp")
    fun saveRasp(@RequestBody saveTask: TasksDao): Boolean? {
        return try {
            tasksRepo.save(saveTask)
            true
        } catch (e: Exception) {
            null
        }
    }

    @PostMapping("/deleteRasp")
    fun deleteRasp(@RequestBody findMyTasks: FindMyTasks): Boolean? {
        return try {
            tasksRepo.deleteById(findMyTasks.uId)
            true
        } catch (e: Exception) {
            null
        }
    }

    @PostMapping("/getMyRasp")
    fun test(@RequestBody findMyTasks: FindMyTasks): List<MyTasks>? {
        return try {
            tasksRepo.getMyTasks(findMyTasks.uId)
        } catch (e: Exception) {
            null
        }
    }

    @PostMapping("/deleteAcc")
    fun deleteAcc(@RequestBody userId: UserId): Boolean? {
        return try {
            userRepo.deleteAcc(userId.id)
            true
        } catch (e: Exception) {
            logger.error(e.message)
            null
        }
    }

    @PostMapping("/createGoogle")
    fun createGoogle(@RequestBody userId: UserId): Boolean? {
        return try {
            userRepo.deleteAcc(userId.id)
            true
        } catch (e: Exception) {
            null
        }
    }

}