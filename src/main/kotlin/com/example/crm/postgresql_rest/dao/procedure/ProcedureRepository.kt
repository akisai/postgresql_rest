package com.example.crm.postgresql_rest.dao.procedure

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProcedureRepository : CrudRepository<ProcedureDao, Long>