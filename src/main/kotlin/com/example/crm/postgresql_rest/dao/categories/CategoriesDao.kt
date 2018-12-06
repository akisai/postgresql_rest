package com.example.crm.postgresql_rest.dao.categories

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "categories")
class CategoriesDao(
        val category: String,
        val rules: String,
        @Id
        val id: Long = -1
) {
    private constructor() : this("", "")
}