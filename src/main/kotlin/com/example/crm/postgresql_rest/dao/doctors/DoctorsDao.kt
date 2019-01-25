package com.example.crm.postgresql_rest.dao.doctors

import org.hibernate.annotations.Type
import java.time.LocalTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "doctors")
class DoctorsDao(
        val userId: Long = -1,
        val start: LocalTime? = null,
        val end: LocalTime? = null,
        val available: Boolean? = null,
        val procedure: String? = null,
        @Id
        val id: Long = -1
)