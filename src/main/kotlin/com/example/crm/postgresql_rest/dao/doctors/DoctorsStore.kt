package com.example.crm.postgresql_rest.dao.doctors

import java.time.LocalDate
import java.time.LocalTime

data class DoctorsInfo(val name: String, val surname: String, val birthday: LocalDate, val procedure: String, val start: LocalTime, val end: LocalTime, val userId: Long, val id: Long)

data class TimeInfo(val id: Long, val start: LocalTime, val end: LocalTime)

data class FindTimeInfo(val id: Long)