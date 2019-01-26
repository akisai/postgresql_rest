package com.example.crm.postgresql_rest.dao.procedure

data class ProcedureInfo(val id: Long, val name: String, val description: String, val cost: Long, val doctors: String)