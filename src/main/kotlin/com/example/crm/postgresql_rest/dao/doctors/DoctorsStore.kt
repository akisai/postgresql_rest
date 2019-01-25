package com.example.crm.postgresql_rest.dao.doctors

import java.time.LocalDate
import java.time.LocalTime

data class DoctorsInfo(val name: String, val surname: String, val birthday: LocalDate, val procedure: String, val start: LocalTime, val end: LocalTime)