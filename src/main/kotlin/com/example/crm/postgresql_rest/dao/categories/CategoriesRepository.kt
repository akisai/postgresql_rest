package com.example.crm.postgresql_rest.dao.categories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriesRepository : CrudRepository<CategoriesDao, Long> {
    fun findByCategory(user_id: String): CategoriesDao?
}