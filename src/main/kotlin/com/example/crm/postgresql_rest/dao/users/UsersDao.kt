package com.example.crm.postgresql_rest.dao.users

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "users")
class UsersDao(
        val login: String,
        val password: String,
        val registration_date: LocalDateTime,
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
        val id: Long = -1
) {
    private constructor(date: LocalDateTime) : this("", "", date)
}