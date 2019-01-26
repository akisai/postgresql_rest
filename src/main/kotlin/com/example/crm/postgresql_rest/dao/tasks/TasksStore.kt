package com.example.crm.postgresql_rest.dao.tasks

import java.time.LocalDate

data class FindTasks(val doctorId: Long, val date: LocalDate)