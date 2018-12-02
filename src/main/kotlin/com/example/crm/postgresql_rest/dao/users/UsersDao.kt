package com.example.crm.postgresql_rest.dao.users

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "users")
class UsersDao(
        val login: String,
        val password: String,
        val registration_date: LocalDate,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1
) {
    private constructor(date: LocalDate) : this("", "", date)
}