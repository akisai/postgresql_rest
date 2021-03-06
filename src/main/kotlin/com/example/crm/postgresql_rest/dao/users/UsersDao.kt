package com.example.crm.postgresql_rest.dao.users

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "users")
@NamedStoredProcedureQuery(
        name = "deleteAcc",
        procedureName = "delete_acc",
        parameters = [StoredProcedureParameter(
                mode = ParameterMode.IN, name = "uId", type = Long::class
        )]
)
class UsersDao(
        val login: String,
        val password: String,
        val registration_date: LocalDateTime,
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
        @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
        val id: Long = -1
) {
    private constructor(date: LocalDateTime) : this("", "", date)
}