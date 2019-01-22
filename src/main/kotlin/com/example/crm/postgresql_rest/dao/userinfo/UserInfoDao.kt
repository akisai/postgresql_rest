package com.example.crm.postgresql_rest.dao.userinfo

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "user_info")
class UserInfoDao(
        val category: String,
        @Column(name = "user_id")
        val userId: Long = -1,
        val name: String? = null,
        val surname: String? = null,
        val patronymic: String? = null,
        val birthday: LocalDate? = null,
        val email: String? = null,
        val pic: String? = null,
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_id_seq")
        @SequenceGenerator(name = "user_info_id_seq", sequenceName = "user_info_id_seq", allocationSize = 1)
        val id: Long = -1
) {
    private constructor() : this("")
}
