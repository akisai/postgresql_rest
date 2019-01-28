package com.example.crm.postgresql_rest.dao.tasks

import java.time.LocalDate
import java.time.LocalTime

data class FindTasks(val doctorId: Long, val date: LocalDate)

data class FindMyTasks(val uId: Long)

interface MyTasks {
    val time: LocalTime
    val date: LocalDate
    val name: String
    val surname: String
    val procedure: String
    val description: String
    val cost: Long
}