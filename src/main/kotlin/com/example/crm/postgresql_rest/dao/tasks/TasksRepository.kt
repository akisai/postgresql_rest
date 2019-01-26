package com.example.crm.postgresql_rest.dao.tasks

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface TasksRepository : CrudRepository<TasksDao, Long> {

    fun findAllByDoctorIdAndDate(doctorId: Long, date: LocalDate): ArrayList<TasksDao>?
}