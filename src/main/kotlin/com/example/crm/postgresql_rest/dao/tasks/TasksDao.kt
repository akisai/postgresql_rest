package com.example.crm.postgresql_rest.dao.tasks

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name = "tasks")
class TasksDao(
        @Column(name = "user_id")
        val userId: Long = -1,
        @Column(name = "doctor_id")
        val doctorId: Long = -1,
        @Column(name = "procedure_id")
        val procedureId: Long = -1,
        val time: LocalTime? = null,
        val date: LocalDate? = null,
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_id_seq")
        @SequenceGenerator(name = "task_id_seq", sequenceName = "task_id_seq", allocationSize = 1)
        val id: Long = -1
)