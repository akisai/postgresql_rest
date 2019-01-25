package com.example.crm.postgresql_rest.dao.doctors

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DoctorsRepository : CrudRepository<DoctorsDao, Long> {
}