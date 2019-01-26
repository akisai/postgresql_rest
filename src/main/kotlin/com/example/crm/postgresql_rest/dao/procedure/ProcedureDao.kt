package com.example.crm.postgresql_rest.dao.procedure

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "services")
class ProcedureDao(
        val name: String? = null,
        val description: String? = null,
        val cost: Long? = null,
        @Id
        val id: Long = -1
)