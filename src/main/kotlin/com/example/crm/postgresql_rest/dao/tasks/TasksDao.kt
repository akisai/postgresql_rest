package com.example.crm.postgresql_rest.dao.tasks

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tasks")
class TasksDao(
        @Column(name = "user_id")
        val userId: Long = -1,
        @Column(name = "doctor_id")
        val doctorId: Long = -1,
        val time: LocalTime? = null,
        val date: LocalDate? = null,
        @Id
        val id: Long = -1
)